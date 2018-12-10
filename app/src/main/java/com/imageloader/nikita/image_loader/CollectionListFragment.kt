package com.imageloader.nikita.image_loader

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter
import com.imageloader.nikita.image_loader.Handlers.CollectionHandler
import com.imageloader.nikita.image_loader.Servers.DatabaseServer
import com.imageloader.nikita.image_loader.utils.DataBaseState
import com.imageloader.nikita.image_loader.utils.PreviewImageModel

class CollectionListFragment : CommonViewFragment() {


    private val listOfReceiver = ArrayList<BroadcastReceiver>()
    private lateinit var touchCallback: ItemTouchHelper.SimpleCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.collections_list_fragment, container, false)
        listView = view.findViewById(R.id.list_item)
        listAdapter = AllImageListAdapter(listOfPreview)
        listView.adapter = listAdapter
        val layout = view.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        layout.setOnRefreshListener {
            val broadcastReceiver = CollectionHandler(listAdapter, listOfPreview, layout).detailReceiver
            val filter = IntentFilter("GET_ALL")
            filter.addCategory(Intent.CATEGORY_DEFAULT)
            context?.registerReceiver(broadcastReceiver, filter)
            val intent = Intent(context, DatabaseServer::class.java)
            intent.putExtra("command", DataBaseState.GET)
            context?.startService(intent)
            listOfReceiver.add(broadcastReceiver)
        }
        touchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
                return false
            }


            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
                if (p1 == ItemTouchHelper.RIGHT) {
                    val position = p0.adapterPosition
                    listAdapter.notifyItemChanged(position)

                    val filter = IntentFilter("DELETE_FROM_DATABASE_${listOfPreview[position].toString()}")
                    filter.addCategory(Intent.CATEGORY_DEFAULT)
                    val intent = Intent(context, DatabaseServer::class.java)
                    intent.putExtra("command", DataBaseState.DELETE)
                    intent.putExtra("value", listOfPreview[position])
                    context?.startService(intent)

                    listAdapter.notifyItemRemoved(position)
                    listOfPreview.removeAt(position)
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val background: ColorDrawable
                val currentView = viewHolder.itemView
                val backgroundCornerOffset = 20
                if (dX > 0) {
                    background = ColorDrawable(Color.RED)
                    background.setBounds(
                        currentView.left,
                        currentView.top,
                        currentView.left + dX.toInt(),
                        currentView.bottom
                    )
                } else {
                    background = ColorDrawable(Color.BLACK)
                    background.setBounds(0, 0, 0, 0)
                }

                background.draw(c)
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }
        ItemTouchHelper(touchCallback).attachToRecyclerView(listView)
        addReplaceFragment()
        val customBundle = this.arguments ?: Bundle()
        customBundle.putAll(savedInstanceState ?: Bundle())
        if (customBundle.containsKey("list_images")) {
            listOfPreview.addAll(customBundle.getParcelableArrayList("list_images") ?: emptyList())
            listAdapter.notifyDataSetChanged()
        }
        return view
    }

    override fun onDestroy() {
        listOfReceiver.forEach {
            context?.unregisterReceiver(it)
        }
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("list_images", listOfPreview)
    }
}
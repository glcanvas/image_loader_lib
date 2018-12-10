package com.imageloader.nikita.image_loader

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter
import com.imageloader.nikita.image_loader.Servers.DatabaseServer
import com.imageloader.nikita.image_loader.utils.AsyncLoadPreviewList
import com.imageloader.nikita.image_loader.utils.DataBaseState
import com.imageloader.nikita.image_loader.utils.PreviewImageModel

open class CommonViewFragment : Fragment() {

    protected lateinit var listView: RecyclerView
    protected lateinit var listAdapter: AllImageListAdapter

    protected val listOfPreview = ArrayList<PreviewImageModel>()
    protected val setOfAsyncTasks = HashSet<AsyncLoadPreviewList>()
    protected var currentPage = 1

    private lateinit var touchCallback: ItemTouchHelper.SimpleCallback

    private var currentActivity: MainActivity? = null
    private var currentDimension: String? = null

    open fun asyncLoadList() {
        val task =
            AsyncLoadPreviewList(listOfPreview, listAdapter, setOfAsyncTasks)
        task.execute(currentPage.toString())
        currentPage++
    }

    override fun onDestroy() {
        super.onDestroy()
        setOfAsyncTasks.forEach { it.cancel(true) }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("list_images", listOfPreview)
        outState.putInt("current_page", currentPage)
    }

    protected fun saveState(savedInstanceState: Bundle?) {
        val customBundle = this.arguments ?: Bundle()
        customBundle.putAll(savedInstanceState ?: Bundle())
        if (customBundle.containsKey("current_page")) {
            currentPage = customBundle.getInt("current_page")
        }
        if (customBundle.containsKey("list_images")) {
            listOfPreview.addAll(customBundle.getParcelableArrayList("list_images") ?: emptyList())
            listAdapter.notifyDataSetChanged()
        }
    }

    protected fun addSwipeCallback() {
        touchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
                return false
            }


            override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
                if (p1 == ItemTouchHelper.LEFT) {
                    listAdapter.notifyItemChanged(p0.adapterPosition)
                    val filter = IntentFilter("SAVE_TO_DATABASE_${listOfPreview[p0.adapterPosition].toString()}")
                    filter.addCategory(Intent.CATEGORY_DEFAULT)
                    val intent = Intent(context, DatabaseServer::class.java)
                    intent.putExtra("command", DataBaseState.SAVE)
                    intent.putExtra("value", listOfPreview[p0.adapterPosition])
                    context?.startService(intent)
                }
                if (p1 == ItemTouchHelper.RIGHT) {
                    val position = p0.adapterPosition
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
                } else if (dX < 0) {
                    background = ColorDrawable(Color.YELLOW)
                    background.setBounds(
                        currentView.right + dX.toInt(),
                        currentView.top,
                        currentView.right,
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
    }

    protected fun addReplaceFragment() {
        if (currentActivity == null) {
            currentActivity = (activity as MainActivity)
        }
        if (currentDimension == null) {
            currentDimension = (currentActivity?.application as CommonStateApplication).dimension ?: "normal"
        }

        listView.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val tmpBundle = Bundle()
                tmpBundle.putString("image", listOfPreview[position].fullLink)
                if (currentDimension == "normal") {
                    val fragment = DetailFragment()
                    fragment.arguments = tmpBundle
                    currentActivity?.fragmentManager?.beginTransaction()?.add(R.id.listholder, fragment)
                        ?.addToBackStack(null)?.commit()
                }
            }
        })
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View) {
                view.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View) {
                view.setOnClickListener {
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                }
            }
        })

    }
}
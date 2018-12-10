package com.imageloader.nikita.image_loader

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter
import com.imageloader.nikita.image_loader.utils.AsyncLoadPreviewList

class RequestImageLIstFragment : CommonViewFragment() {
    lateinit var searchInput: SearchView
    private var lastRequest: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.request_list_fragment, container, false)
        val appl = activity?.application as CommonStateApplication
        //Log.d("1111", appl.dimension)

        listView = view.findViewById(R.id.list_item)
        listAdapter = AllImageListAdapter(listOfPreview)
        listView.adapter = listAdapter
        searchInput = view.findViewById(R.id.search_input)
        searchInput.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    listOfPreview.clear()
                    listAdapter.notifyDataSetChanged()
                    currentPage = 1
                    lastRequest = query
                    asyncLoadList(query)
                } else {
                    lastRequest = null
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        listView.addOnScrollListener(object :
            EndlessRecyclerViewScrollListener(listView.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                if (lastRequest != null) {
                    currentPage++
                    asyncLoadList(lastRequest as String)
                }

            }

        })
        addSwipeCallback()
        saveState(savedInstanceState)
        addReplaceFragment()
        return view
    }

    private fun asyncLoadList(query: String) {
        val task =
            AsyncLoadPreviewList(listOfPreview, listAdapter, setOfAsyncTasks)
        task.execute(currentPage.toString(), query)
        currentPage++
    }

}
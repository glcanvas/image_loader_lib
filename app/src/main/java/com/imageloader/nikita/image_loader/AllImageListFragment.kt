package com.imageloader.nikita.image_loader


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter



class AllImageListFragment : CommonViewFragment() {

    private lateinit var loadYetButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.all_list_fragment, container, false)

        loadYetButton = view.findViewById(R.id.load_button)
        listView = view.findViewById(R.id.list_item)
        listAdapter = AllImageListAdapter(listOfPreview)
        listView.adapter = listAdapter
        loadYetButton.setOnClickListener { asyncLoadList() }

        addSwipeCallback()
        saveState(savedInstanceState)
        addReplaceFragment()
        return view
    }
}
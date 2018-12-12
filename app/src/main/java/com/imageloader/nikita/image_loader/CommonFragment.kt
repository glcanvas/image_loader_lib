package com.imageloader.nikita.image_loader

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imageloader.nikita.image_loader.Adapters.CommonFragmentAdapter
import kotlinx.android.synthetic.main.common_list_views.view.*

class CommonFragment : Fragment() {
    private lateinit var currentApplication: CommonStateApplication
    private lateinit var adapter: CommonFragmentAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.common_list_views, container, false)
        val page = view.common_page
        val tabLayout = view.tab_layout_menu
        tabLayout.addTab(tabLayout.newTab().setText("search by request"))
        tabLayout.addTab(tabLayout.newTab().setText("all images"))
        tabLayout.addTab(tabLayout.newTab().setText("saved"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        currentApplication = activity?.application as CommonStateApplication
        adapter = CommonFragmentAdapter(
            activity?.supportFragmentManager, 3)
        page.adapter = adapter
        if (currentApplication.requestFragment != null) {
            page.setCurrentItem(2, false)

        }
        page.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                page.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        return view
    }
}
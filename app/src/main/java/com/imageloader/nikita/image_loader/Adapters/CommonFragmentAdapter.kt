package com.imageloader.nikita.image_loader.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.imageloader.nikita.image_loader.*

class CommonFragmentAdapter(
    fragmentManager: FragmentManager?, val numberOfTabs: Int
) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return RequestImageLIstFragment()

            1 -> return AllImageListFragment()

            else -> return CollectionListFragment()

        }
    }

    override fun getCount(): Int {
        return numberOfTabs
    }
}
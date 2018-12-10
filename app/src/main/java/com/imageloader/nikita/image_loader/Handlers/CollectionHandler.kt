package com.imageloader.nikita.image_loader.Handlers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.widget.SwipeRefreshLayout
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter
import com.imageloader.nikita.image_loader.utils.PreviewImageModel

class CollectionHandler(
    val adapter: AllImageListAdapter,
    val loadedData: ArrayList<PreviewImageModel>,
    val layout: SwipeRefreshLayout
) {
    var receiver: BroadcastReceiver
    val detailReceiver: BroadcastReceiver
        get() = this.receiver

    init {
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                layout.isRefreshing = false
                if (intent?.extras?.containsKey("result") == false) {
                    return
                }
                val result = intent?.extras?.get("result") as ArrayList<PreviewImageModel>
                loadedData.clear()
                loadedData.addAll(result)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
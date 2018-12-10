package com.imageloader.nikita.image_loader.Adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imageloader.nikita.image_loader.ListsHandler.AllImageListHolder
import com.imageloader.nikita.image_loader.R
import com.imageloader.nikita.image_loader.utils.LoadProgress
import com.imageloader.nikita.image_loader.utils.PreviewImageModel
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import java.lang.Exception

class AllImageListAdapter(
    private val items: ArrayList<PreviewImageModel>
) : RecyclerView.Adapter<AllImageListHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(item: AllImageListHolder, index: Int) {
        val currentData = items[index]
        item.author_name.text = currentData.authorName
        item.description.text = currentData.description
        /*when (currentData.isLoadImage) {
            LoadProgress.NOT_STARTED -> {
                Log.d("!!!!!", "Not start")
                currentData.isLoadImage = LoadProgress.IN_PROGRESS
                Picasso.get().load(currentData.previewLink).tag(currentData.previewLink as Any)
                    .into(item.previewImage, object : Callback {
                        override fun onSuccess() {
                            item.progressBar.visibility = View.GONE
                            item.previewImage.visibility = View.VISIBLE
                            currentData.isLoadImage = LoadProgress.IS_LOAD
                        }

                        override fun onError(e: Exception?) {
                            currentData.isLoadImage = LoadProgress.NOT_STARTED
                        }
                    })
            }
            LoadProgress.IN_PROGRESS -> {
                Picasso.get().resumeTag(currentData.previewLink as Any)
                Log.d("!!!!!", "in progress")
            }

            LoadProgress.IS_LOAD -> {
                Picasso.get().load(currentData.previewLink).networkPolicy(NetworkPolicy.OFFLINE).into(
                    item.previewImage
                )
                Log.d("!!!!!", "is load")
            }
        }*/
        Picasso.get().load(currentData.previewLink).tag(currentData.previewLink as Any)
            .into(item.previewImage, object : Callback {
                override fun onSuccess() {
                    item.progressBar.visibility = View.GONE
                    item.previewImage.visibility = View.VISIBLE
                    currentData.isLoadImage = LoadProgress.IS_LOAD
                }

                override fun onError(e: Exception?) {
                    currentData.isLoadImage = LoadProgress.NOT_STARTED
                }
            })
    }

    override fun onCreateViewHolder(group: ViewGroup, p1: Int): AllImageListHolder {
        val view = LayoutInflater.from(group.context).inflate(R.layout.item_all_image_list, group, false)
        return AllImageListHolder(view)
    }

}

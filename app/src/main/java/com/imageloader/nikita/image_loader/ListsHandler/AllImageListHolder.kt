package com.imageloader.nikita.image_loader.ListsHandler

import android.view.View
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.imageloader.nikita.image_loader.R

class AllImageListHolder(view: View) : RecyclerView.ViewHolder(view) {
    var author_name = view.findViewById<TextView>(R.id.holder_author_name)
    var description = view.findViewById<TextView>(R.id.holder_description)
    var previewImage = view.findViewById<ImageView>(R.id.holder_preview_image)
    var progressBar = view.findViewById<ProgressBar>(R.id.holder_progress_bar)
}
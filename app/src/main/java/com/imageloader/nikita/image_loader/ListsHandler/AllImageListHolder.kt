package com.imageloader.nikita.image_loader.ListsHandler

import android.view.View
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.item_all_image_list.view.*

class AllImageListHolder(view: View) : RecyclerView.ViewHolder(view) {
    var author_name = view.holder_author_name
    var description = view.holder_description
    var previewImage = view.holder_preview_image
    var progressBar = view.holder_progress_bar
}
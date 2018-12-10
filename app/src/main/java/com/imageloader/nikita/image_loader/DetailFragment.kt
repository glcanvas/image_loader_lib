package com.imageloader.nikita.image_loader

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class DetailFragment : Fragment() {
    private var fullLink: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        val placeHolder = view.findViewById<ImageView>(R.id.detailImage)
        val bar = view.findViewById<ProgressBar>(R.id.full_image_load_bar)
        if (this.arguments?.containsKey("image") == true) {
            fullLink = this.arguments?.getString("image") ?: ""
        }
        if (fullLink == null) {
            bar.visibility = View.GONE
            placeHolder.visibility = View.GONE
        } else {
            Picasso.get().load(fullLink).tag("full_load").into(placeHolder, object : Callback {
                override fun onSuccess() {
                    bar.visibility = View.GONE
                    placeHolder.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                }
            })
        }

        return view
    }
}
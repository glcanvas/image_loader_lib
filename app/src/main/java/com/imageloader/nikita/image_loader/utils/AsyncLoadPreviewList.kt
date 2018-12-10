package com.imageloader.nikita.image_loader.utils

import android.os.AsyncTask
import com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter
import retrofit2.Response
import java.io.IOException

class AsyncLoadPreviewList(

    val listOfPreview: ArrayList<PreviewImageModel>,
    val adapter: AllImageListAdapter,
    val set: HashSet<AsyncLoadPreviewList>
) : AsyncTask<String, Unit, List<PreviewImageModel>>() {
    override fun onPreExecute() {
        set.add(this)
    }

    override fun onPostExecute(result: List<PreviewImageModel>?) {
        set.remove(this)
        listOfPreview.addAll(result ?: emptyList())
        adapter.notifyDataSetChanged()
    }

    override fun onCancelled(result: List<PreviewImageModel>?) {
        set.remove(this)
    }

    override fun onCancelled() {
        set.remove(this)
    }

    override fun doInBackground(vararg params: String?): List<PreviewImageModel> {

        val offset = params[0]?.toInt() ?: 1
        var query: String = ""
        if (params.size == 2) {
            query = params[1] ?: ""
        }
        val loadData = ArrayList<PreviewImageModel>()
        val f = UnsplashFactory.create()

        val tmpResult = when (params.size) {
            1 ->
                try {
                    f.photos(
                        "73e14423b06e6a0f7715e4ea90b0c9b8f3e94fa21d6281ed2b730da4cb79d016",
                        offset
                    ).execute()
                } catch (e: IOException) {
                    null
                }
            else -> try {
                f.photosByQuery(
                    "73e14423b06e6a0f7715e4ea90b0c9b8f3e94fa21d6281ed2b730da4cb79d016",
                    offset,
                    query
                ).execute()
            } catch (e: IOException) {
                null
            }
        }
        if (isCancelled) {
            return loadData
        }
        if (tmpResult?.isSuccessful != true) {
            return loadData
        }
        val result = when (params.size) {
            1 -> tmpResult.body() as ArrayList<RetrofitImageList>
            else -> {
                val data = tmpResult.body() as SearchResult
                data.results
            }
        }

        result.forEach {
            loadData.add(
                PreviewImageModel(
                    it.user.name,
                    it.description,
                    it.urls.full,
                    it.urls.small,
                    LoadProgress.NOT_STARTED
                )
            )
        }

        return loadData
    }

}
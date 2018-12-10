package com.imageloader.nikita.image_loader.utils

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {
    @GET("photos")
    fun photos(@Query("client_id") client_id: String, @Query("page") page: Int): Call<ArrayList<RetrofitImageList>>

    @GET("search/photos")
    fun photosByQuery(
        @Query("client_id") client_id: String, @Query("page") page: Int,
        @Query("query") query: String
    ): Call<SearchResult>
}

object UnsplashFactory {
    fun create(): UnsplashService {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder().client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.unsplash.com/")
            .build()

        return retrofit.create(UnsplashService::class.java)
    }
}
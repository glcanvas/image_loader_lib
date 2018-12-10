package com.imageloader.nikita.image_loader

import android.app.Application
import android.support.v4.app.Fragment

class CommonStateApplication : Application() {
    lateinit var instance: CommonStateApplication

    var dimension: String? = null
    var currentFragment: String? = null

    var requestFragment: Fragment? = null
    var defaultFragment: Fragment? = null
    var collectionFragment: Fragment? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}
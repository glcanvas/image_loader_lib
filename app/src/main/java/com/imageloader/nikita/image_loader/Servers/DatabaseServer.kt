package com.imageloader.nikita.image_loader.Servers

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.imageloader.nikita.image_loader.utils.*

class DatabaseServer : IntentService("DatabaseServer") {
    override fun onHandleIntent(intent: Intent?) {

        if (intent?.extras?.containsKey("command") == false) {
            return
        }
        val command = intent?.extras?.get("command") as DataBaseState
        val database = SavedDataBase.getInstance(this)
        if (command == DataBaseState.SAVE) {
            saveToDataBase(intent, database)
        } else if (command == DataBaseState.GET) {
            loadFromDataBase(database)
        } else if (command == DataBaseState.DELETE) {
            detleteFromDataBase(intent, database)
        }


    }

    private fun saveToDataBase(intent: Intent, database: SavedDataBase?) {
        if (intent.extras?.containsKey("value") == false) {
            return
        }
        val value = intent.extras?.get("value") as PreviewImageModel
        val exist = database?.savedDataDAO()?.existValueByFullLink(value.fullLink)
        if (exist == null) {
            Log.d("database_server", "${value.fullLink} not found")
            val tmp = SavedData()
            tmp.authorName = value.authorName
            tmp.previewLink = value.previewLink
            tmp.fullLink = value.fullLink
            tmp.description = value.description
            database?.savedDataDAO()?.insert(tmp)
        } else {
            Log.d("database_server", "${value.fullLink} was found")
        }
    }

    private fun loadFromDataBase(database: SavedDataBase?) {
        val result = database?.savedDataDAO()?.getAll() ?: listOf()
        val formatedData = ArrayList<PreviewImageModel>()
        result.forEach {
            formatedData.add(
                PreviewImageModel(
                    authorName = it.authorName,
                    description = it.description,
                    fullLink = it.fullLink,
                    previewLink = it.previewLink,
                    isLoadImage = LoadProgress.NOT_STARTED
                )
            )
        }
        val intent = Intent()
        intent.action = "GET_ALL"
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.putParcelableArrayListExtra("result", formatedData)
        sendBroadcast(intent)
    }

    private fun detleteFromDataBase(intent: Intent, database: SavedDataBase?) {
        if (intent.extras?.containsKey("value") == false) {
            return
        }
        val value = intent.extras?.get("value") as PreviewImageModel
        database?.savedDataDAO()?.deleteByFullLink(value.fullLink)
    }
}
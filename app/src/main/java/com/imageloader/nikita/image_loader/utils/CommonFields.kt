package com.imageloader.nikita.image_loader.utils

import android.arch.persistence.room.*
import android.content.Context
import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PreviewImageModel(
    var authorName: String?,
    var description: String?,
    var fullLink: String?,
    var previewLink: String?,
    var isLoadImage: LoadProgress
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        when (parcel.readInt()) {
            0 -> LoadProgress.NOT_STARTED
            1 -> LoadProgress.IN_PROGRESS
            else -> LoadProgress.IS_LOAD
        }
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(authorName)
        dest?.writeString(description)
        dest?.writeString(fullLink)
        dest?.writeString(previewLink)
        dest?.writeInt(
            when (isLoadImage) {
                LoadProgress.NOT_STARTED -> 0

                LoadProgress.IN_PROGRESS -> 1

                LoadProgress.IS_LOAD -> 2

            }
        )
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PreviewImageModel> {
        override fun createFromParcel(parcel: Parcel): PreviewImageModel {
            return PreviewImageModel(parcel)
        }

        override fun newArray(size: Int): Array<PreviewImageModel?> {
            return arrayOfNulls(size)
        }
    }

}

data class RetrofitImageList(
    @SerializedName("description")
    val description: String,
    val user: User,
    val urls: Urls
)

data class SearchResult(
    val results: ArrayList<RetrofitImageList>
)

data class User(val name: String)

data class Urls(
    @SerializedName("raw")
    val raw: String,
    @SerializedName("full")
    val full: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("thumb")
    val thumb: String
)

enum class LoadProgress {
    NOT_STARTED,
    IN_PROGRESS,
    IS_LOAD
}

enum class DataBaseState {
    SAVE,
    GET,
    EXIST,
    DELETE
}

@Entity(tableName = "savedData")
data class SavedData(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "author_name") var authorName: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "full_link") var fullLink: String?,
    @ColumnInfo(name = "preview_link") var previewLink: String?
) {
    constructor() : this(null, "", "", "", "")
}

@Dao
interface SavedDataDAO {
    @Query("SELECT * from savedData")
    fun getAll(): List<SavedData>

    @Insert
    fun insert(savedData: SavedData)

    @Query("SELECT * from savedData where full_link=:fullLink LIMIT 1")
    fun existValueByFullLink(fullLink: String?): SavedData?

    @Query("DELETE FROM savedData where full_link=:fullLink")
    fun deleteByFullLink(fullLink: String?)
}

@Database(entities = arrayOf(SavedData::class), version = 1)
abstract class SavedDataBase : RoomDatabase() {
    abstract fun savedDataDAO(): SavedDataDAO

    companion object {
        private var INSTANCE: SavedDataBase? = null

        fun getInstance(context: Context): SavedDataBase? {
            if (INSTANCE == null) {
                synchronized(SavedDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SavedDataBase::class.java, "preview_images.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
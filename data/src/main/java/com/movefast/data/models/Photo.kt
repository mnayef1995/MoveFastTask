package com.movefast.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.movefast.data.moshi.HexColor
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Entity(tableName = "photos")
@JsonClass(generateAdapter = true)
class Photo(

    @PrimaryKey
    @Json(name = "id")
    val id: String,

    @Json(name = "alt_description")
    val altDescription: String? = null,

    @HexColor
    @Json(name = "color")
    val color: Int,

    @Embedded
    @Json(name = "urls")
    val urls: PhotoUrls? = null
)

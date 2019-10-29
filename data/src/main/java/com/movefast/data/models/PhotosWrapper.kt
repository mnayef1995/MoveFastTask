package com.movefast.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@JsonClass(generateAdapter = true)
data class PhotosWrapper(

    @Json(name = "results")
    val results: MutableList<Photo>
)

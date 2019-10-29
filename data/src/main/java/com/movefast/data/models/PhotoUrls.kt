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
data class PhotoUrls(

    @Json(name = "raw")
    val raw: String? = null,

    @Json(name = "full")
    val full: String? = null,

    @Json(name = "regular")
    val regular: String? = null,

    @Json(name = "small")
    val small: String? = null,

    @Json(name = "thumb")
    val thumb: String? = null
)

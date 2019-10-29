package com.movefast.data.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class ColorAdapter {

    @ToJson
    fun toJson(@HexColor rgb: Int): String {
        return String.format("#%06x", rgb)
    }

    @FromJson
    @HexColor
    fun fromJson(rgb: String): Int {
        return Integer.parseInt(rgb.substring(1), HEX_RADIX)
    }

    private companion object {

        private const val HEX_RADIX = 16
    }
}

package com.movefast.data.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
interface BindingAdapters {

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?)

    @BindingAdapter("roundedImageUrl", "radius")
    fun ImageView.setRoundedImageUrl(url: String?, radius: Int)
}

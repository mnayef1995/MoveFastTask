package com.movefast.data.binding

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.movefast.data.dpToPx
import com.movefast.data.glide.GlideApp

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class BindingAdaptersImpl : BindingAdapters {

    override fun ImageView.setImageUrl(url: String?) {
        GlideApp.with(this).load(url).into(this)
    }

    override fun ImageView.setRoundedImageUrl(url: String?, radius: Int) {
        val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(radius.dpToPx(context).toInt()))
        GlideApp.with(this).load(url).apply(requestOptions).into(this)
    }
}

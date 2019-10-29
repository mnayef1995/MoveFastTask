package com.movefast.core.utils.android

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline callback: (T) -> Unit) {
    observe(owner, Observer { callback(it) })
}

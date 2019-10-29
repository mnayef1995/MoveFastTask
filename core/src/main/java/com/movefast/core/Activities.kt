package com.movefast.core

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
fun Context.intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(addressableActivity.action).setPackage(packageName)
}

fun Fragment.intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(addressableActivity.action).setPackage(context?.packageName)
}

interface AddressableActivity {

    val action: String
}

object Activities {

    object Main : AddressableActivity {

        override val action: String = "com.movefast.main.MainActivity"

    }
}

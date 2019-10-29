package com.movefast.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.movefast.core.Activities
import com.movefast.core.intentTo

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentTo(Activities.Main))

        finish()
    }

    override fun onBackPressed() {
        // No impl
    }
}

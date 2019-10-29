package com.movefast.core.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.movefast.core.R

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
abstract class BaseToolbarActivity : BaseActivity() {

    var toolbar: Toolbar? = null

    open fun hasToolbar(): Boolean = true

    open fun hasBackButton(): Boolean = hasToolbar()

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initAndSetToolbar()
        handleBackButton()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> if (hasBackButton()) {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initAndSetToolbar() {
        if (hasToolbar()) {
            toolbar = findViewById(R.id.toolbar)
            if (toolbar != null) {
                setSupportActionBar(toolbar)
            }
        }
    }

    private fun handleBackButton() {
        if (hasBackButton()) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}

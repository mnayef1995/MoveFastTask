package com.movefast.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.movefast.core.activities.BaseToolbarActivity
import com.movefast.core.custom.views.CustomBottomAppBar
import com.movefast.core.utils.android.bindView
import javax.inject.Inject

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class MainActivity : BaseToolbarActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val navController by lazy { findNavController(R.id.fragment_activity_main_navigation) }
    private val bottomNavigationView: BottomNavigationView? by bindView(R.id.bottom_navigation_view_activity_home)
    private val bottomAppBar: CustomBottomAppBar? by bindView(R.id.bottom_app_bar_activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomAppBar?.onSlideDown { it?.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END }
        bottomAppBar?.onSlideUp { it?.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initNavigation()
    }

    private fun initNavigation() {
        bottomNavigationView?.setupWithNavController(navController)
        toolbar?.setupWithNavController(navController)
        toolbar?.setNavigationOnClickListener { onSupportNavigateUp() }
    }
}

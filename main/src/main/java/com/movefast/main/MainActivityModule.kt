package com.movefast.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
abstract class MainActivityModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideViewModel(
            activity: AppCompatActivity,
            factory: MainViewModelFactory
        ): MainViewModel {
            return ViewModelProvider(activity, factory)[MainViewModel::class.java]
        }
    }

    @Binds
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity
}

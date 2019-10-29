package com.movefast.di

import com.movefast.main.MainActivity
import com.movefast.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}

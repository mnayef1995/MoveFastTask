package com.movefast.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}

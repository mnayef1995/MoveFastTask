package com.movefast.di

import com.movefast.gallery.GalleryFragment
import com.movefast.gallery.GalleryFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [GalleryFragmentModule::class])
    abstract fun bindGalleryFragment(): GalleryFragment
}

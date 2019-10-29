package com.movefast.gallery

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.movefast.data.CoroutinesContextProvider
import com.movefast.data.repositories.gallery.GalleryRepository
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
abstract class GalleryFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideViewModel(
            fragment: Fragment,
            factory: GalleryViewModelFactory
        ): GalleryViewModel {
            return ViewModelProvider(fragment, factory)[GalleryViewModel::class.java]
        }

        @Provides
        @JvmStatic
        fun provideGalleryViewModelFactory(
            fragment: Fragment,
            galleryRepository: GalleryRepository,
            coroutinesContextProvider: CoroutinesContextProvider
        ): GalleryViewModelFactory {
            val type = fragment.arguments?.getString("type")
            return GalleryViewModelFactory(galleryRepository, coroutinesContextProvider, type)
        }
    }

    @Binds
    abstract fun bindActivity(activity: GalleryFragment): Fragment
}

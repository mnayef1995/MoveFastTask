package com.movefast.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movefast.data.CoroutinesContextProvider
import com.movefast.data.repositories.gallery.GalleryRepository

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryViewModelFactory(
    private val galleryRepository: GalleryRepository,
    private val coroutinesContextProvider: CoroutinesContextProvider,
    private val type: String?
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GalleryViewModel(galleryRepository, coroutinesContextProvider, type) as T
    }
}

package com.movefast.gallery

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.movefast.core.BaseViewModel
import com.movefast.data.CoroutinesContextProvider
import com.movefast.data.models.Photo
import com.movefast.data.network.Resource
import com.movefast.data.network.errorhandling.tryResource
import com.movefast.data.repositories.gallery.GalleryRepository
import com.paginate.Paginate
import kotlinx.coroutines.launch

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryViewModel(
    private val galleryRepository: GalleryRepository,
    private val coroutinesContextProvider: CoroutinesContextProvider,
    private var type: String?,

    private val allPhotos: MutableList<Photo> = mutableListOf()
) : BaseViewModel(), LifecycleObserver, Paginate.Callbacks {

    private var _photosLiveData = MutableLiveData<Resource<Unit>>()
    var photosLiveData: LiveData<Resource<Unit>> = _photosLiveData

    private var loading = false
    private var loadedAllItems = false
    private var page: Int = 1

    fun getPhotos() {
        viewModelScope.launch(coroutinesContextProvider.io) {
            startLoadingPhotosFromUnsplashApi()
        }
    }

    private suspend fun startLoadingPhotosFromUnsplashApi() {
        loading = true
        handleShowingProgress()
        handleGettingDataOrHandleException()
        loading = false
    }

    private fun handleShowingProgress() {
        if (page == 1) {
            viewModelScope.launch(coroutinesContextProvider.main) {
                _photosLiveData.value = Resource.Loading(show = true)
            }
        }
    }

    private suspend fun handleGettingDataOrHandleException() {
        var success = false
        val resource = tryResource { galleryRepository.searchByQuery(page, type) }
        if (resource is Resource.Success) {
            if (resource.data?.isEmpty() == true) {
                loadedAllItems = true
            }
            allPhotos.addAll(resource.data ?: listOf())
            success = true
        }
        updateUiAndHideProgress(resource, success)
    }

    private fun updateUiAndHideProgress(resource: Resource<List<Photo>>, success: Boolean) {
        viewModelScope.launch(coroutinesContextProvider.main) {
            _photosLiveData.value = resource.ignoreElement()
            handleHidingProgress()
            if (success) {
                page++
            }
        }
    }

    private fun handleHidingProgress() {
        if (page == 1) {
            _photosLiveData.value = Resource.Loading(show = false)
        }
    }

    fun getPhotosCount(): Int {
        return allPhotos.size
    }

    fun getPhotoBy(position: Int): Photo? {
        return allPhotos[position]
    }

    override fun onLoadMore() {
        getPhotos()
    }

    override fun isLoading(): Boolean = loading

    override fun hasLoadedAllItems(): Boolean = loadedAllItems

    fun getPhotoUrls(): Array<String?> = allPhotos.map { it.urls?.full }.toTypedArray()
}

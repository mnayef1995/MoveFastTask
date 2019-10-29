package com.movefast.gallery

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.movefast.data.CoroutinesContextTestProviderImpl
import com.movefast.data.models.Photo
import com.movefast.data.network.Resource
import com.movefast.data.repositories.gallery.GalleryRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Project: MoveFast
 * Created: Oct 29, 2019
 *
 * @author Mohamed Hamdan
 */
@Suppress("MagicNumber")
@ExperimentalCoroutinesApi
class GalleryViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val allPhotos = spyk(mutableListOf<Photo>())
    private val galleryRepository = mockk<GalleryRepository>(relaxed = true)
    private val coroutinesContextProvider = CoroutinesContextTestProviderImpl()
    private val galleryViewModel = GalleryViewModel(galleryRepository, coroutinesContextProvider, TYPE, allPhotos)

    @Before
    fun before() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `test get photos success`() = runBlockingTest {
        coEvery { galleryRepository.searchByQuery(1, TYPE) } returns listOf()

        var counter = 0
        val liveData = galleryViewModel.photosLiveData
        liveData.observeForever { value ->
            when (counter) {
                0 -> {
                    Assert.assertEquals(value::class, Resource.Loading::class)
                    Assert.assertTrue((value as Resource.Loading<*>).show)
                }
                1 -> {
                    Assert.assertEquals(value::class, Resource.Success::class)
                }
            }
            counter++
        }
        galleryViewModel.getPhotos()

        Assert.assertEquals(counter, 3)
        Assert.assertEquals(liveData.value!!::class, Resource.Loading::class)
        Assert.assertFalse((liveData.value as Resource.Loading<*>).show)

        verify(exactly = 1) { allPhotos.addAll(any()) }
        coVerify { galleryRepository.searchByQuery(1, TYPE) }
    }

    private companion object {

        private const val TYPE = "nature"
    }
}

package com.movefast.di

import com.movefast.data.daos.gallery.LocalGalleryDao
import com.movefast.data.daos.gallery.RemoteGalleryDao
import com.movefast.data.repositories.gallery.GalleryRepository
import com.movefast.data.repositories.gallery.GalleryRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
object RepositoriesModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideGalleryRepository(
        remoteGalleryDao: RemoteGalleryDao,
        localGalleryDao: LocalGalleryDao
    ): GalleryRepository {
        return GalleryRepositoryImpl(remoteGalleryDao, localGalleryDao)
    }

}

package com.movefast.di

import com.movefast.data.daos.gallery.LocalGalleryDao
import com.movefast.data.daos.gallery.RemoteGalleryDao
import com.movefast.data.database.MyDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
object DaosModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideLocalGalleryDao(database: MyDatabase): LocalGalleryDao {
        return database.localGalleryDao()
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideRemoteGalleryDao(retrofit: Retrofit): RemoteGalleryDao {
        return retrofit.create(RemoteGalleryDao::class.java)
    }
}

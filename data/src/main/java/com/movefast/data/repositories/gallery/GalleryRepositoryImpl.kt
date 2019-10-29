package com.movefast.data.repositories.gallery

import com.movefast.data.daos.gallery.LocalGalleryDao
import com.movefast.data.daos.gallery.RemoteGalleryDao
import com.movefast.data.models.Photo

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryRepositoryImpl(
    private val remoteGalleryDao: RemoteGalleryDao,
    private val localGalleryDao: LocalGalleryDao
) : GalleryRepository {

    override suspend fun searchByQuery(page: Int, query: String?): List<Photo> {
        val photos = remoteGalleryDao.searchByQuery(page, query)
        localGalleryDao.insert(photos.results)
        return photos.results
    }
}

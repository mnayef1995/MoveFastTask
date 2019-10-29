package com.movefast.data.repositories.gallery

import com.movefast.data.models.Photo

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
interface GalleryRepository {

    suspend fun searchByQuery(page: Int, query: String?): List<Photo>
}

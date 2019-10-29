package com.movefast.data.daos.gallery

import com.movefast.data.models.PhotosWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
interface RemoteGalleryDao {

    @GET("search/photos")
    suspend fun searchByQuery(@Query("page") page: Int, @Query("query") query: String?): PhotosWrapper
}

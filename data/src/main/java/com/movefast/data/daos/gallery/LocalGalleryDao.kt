package com.movefast.data.daos.gallery

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.movefast.data.models.Photo

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Dao
interface LocalGalleryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photos: List<Photo>)
}

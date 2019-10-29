package com.movefast.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movefast.data.daos.gallery.LocalGalleryDao
import com.movefast.data.models.Photo

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Database(
    entities = [Photo::class],
    version = 1
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun localGalleryDao(): LocalGalleryDao
}

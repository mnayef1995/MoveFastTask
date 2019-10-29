package com.movefast.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.movefast.data.CoroutinesContextProvider
import com.movefast.data.CoroutinesContextProviderImpl
import com.movefast.data.binding.BindingAdapters
import com.movefast.data.binding.BindingAdaptersImpl
import com.movefast.data.database.MyDatabase
import dagger.Module
import dagger.Provides
import io.paperdb.Book
import io.paperdb.Paper
import javax.inject.Singleton

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Module
object CommonModule {

    private const val SHARED_PREFERENCES_NAME = "com.movefast"

    // This injection is a workaround for a known issue in Gradle build system https://github.com/google/dagger/issues/955
    @JvmStatic
    @Singleton
    @Provides
    fun provideDummyObject(): String {
        return ""
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideContextProvider(): CoroutinesContextProvider {
        return CoroutinesContextProviderImpl()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideBook(): Book {
        return Paper.book()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideBindingAdapters(): BindingAdapters {
        return BindingAdaptersImpl()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Application): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "movefast").build()
    }
}

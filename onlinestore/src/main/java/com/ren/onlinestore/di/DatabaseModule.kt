package com.ren.onlinestore.di

import android.content.Context
import androidx.room.Room
import com.ren.onlinestore.data.database.AppDatabase
import com.ren.onlinestore.data.database.AppDatabase.Companion.DATABASE_NAME
import com.ren.onlinestore.data.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "app-database"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    /*
    * @Provides
    * @Singleton
    * fun provideProductDao(@ApplicationContext context: Context): ProductDao {
    *     return AppDatabase.create(context).productDao()
    * }
    *  */
}
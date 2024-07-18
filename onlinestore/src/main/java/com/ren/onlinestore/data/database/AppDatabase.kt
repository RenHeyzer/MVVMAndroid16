package com.ren.onlinestore.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ren.onlinestore.data.database.dao.ProductDao
import com.ren.onlinestore.data.database.entities.ProductDBO

@Database(entities = [ProductDBO::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {

        private const val DATABASE_NAME = "app-database"

        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}
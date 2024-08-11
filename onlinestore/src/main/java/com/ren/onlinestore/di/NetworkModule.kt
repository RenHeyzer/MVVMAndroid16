package com.ren.onlinestore.di

import android.content.Context
import com.ren.onlinestore.OnlineStoreApp
import com.ren.onlinestore.data.database.dao.ProductDao
import com.ren.onlinestore.data.network.RetrofitClient
import com.ren.onlinestore.data.network.api.ProductApiService
import com.ren.onlinestore.data.repositories.ProductDataRepository
import com.ren.onlinestore.data.repositories.ProductRepository
import com.ren.onlinestore.utils.NetworkErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideProductApiService(): ProductApiService {
        return RetrofitClient.productApiService
    }

    @Provides
    @Singleton
    fun provideNetworkErrorHandler(@ApplicationContext context: Context): NetworkErrorHandler {
        return NetworkErrorHandler(context as OnlineStoreApp)
    }
}
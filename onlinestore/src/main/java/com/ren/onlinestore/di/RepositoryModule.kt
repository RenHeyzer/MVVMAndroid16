package com.ren.onlinestore.di

import com.ren.onlinestore.data.repositories.ProductDataRepository
import com.ren.onlinestore.data.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindProductRepository(repositoryImpl: ProductDataRepository): ProductRepository
}
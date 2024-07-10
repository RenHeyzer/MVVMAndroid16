package com.ren.onlinestore.ui.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ren.onlinestore.data.database.AppDatabase
import com.ren.onlinestore.data.repositories.ProductDataRepository
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.models.ProductRepository

class HomeViewModel(
    private val application: Application
) : AndroidViewModel(application) {

    private val productRepository: ProductRepository = ProductDataRepository(
        AppDatabase.create(application.applicationContext).productDao()
    )

    private val _productsState = MediatorLiveData<UiState<List<Product>>>().apply {
        addSource(productRepository.getProducts()) { products ->
            products?.let {
                value = UiState(
                    isLoading = false,
                    success = it
                )
            }
        }
    }
    val productsState: LiveData<UiState<List<Product>>> = _productsState
}

data class UiState<T>(
    val isLoading: Boolean = true,
    val error: Exception? = null,
    val success: T? = null
)
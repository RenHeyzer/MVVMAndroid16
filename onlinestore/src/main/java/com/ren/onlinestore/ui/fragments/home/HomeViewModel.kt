package com.ren.onlinestore.ui.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ren.onlinestore.data.database.AppDatabase
import com.ren.onlinestore.data.repositories.ProductDataRepository
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.data.repositories.ProductRepository
import com.ren.onlinestore.utils.ErrorHandler
import com.ren.onlinestore.utils.UIState
import com.ren.onlinestore.utils.handleAsUIState

class HomeViewModel(
    private val application: Application,
) : AndroidViewModel(application) {

    private val errorHandler = ErrorHandler(application)

    private val productRepository: ProductRepository = ProductDataRepository(
        AppDatabase.create(application.applicationContext).productDao()
    )

    private val _productsState = MutableLiveData<UIState<List<Product>>>(UIState.Loading)
    val productsState: LiveData<UIState<List<Product>>> = _productsState

    init {
        productRepository.getProducts { result ->
            _productsState.value = result.handleAsUIState {
                errorHandler.handleError(it)
            }
        }
    }
}
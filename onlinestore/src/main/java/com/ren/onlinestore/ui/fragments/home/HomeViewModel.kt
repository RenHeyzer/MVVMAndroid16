package com.ren.onlinestore.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ren.onlinestore.data.repositories.ProductRepository
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.utils.NetworkErrorHandler
import com.ren.onlinestore.utils.UIState
import com.ren.onlinestore.utils.handleAsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val errorHandler: NetworkErrorHandler
) : ViewModel() {

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
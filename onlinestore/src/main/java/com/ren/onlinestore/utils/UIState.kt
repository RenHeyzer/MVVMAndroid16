package com.ren.onlinestore.utils

sealed class UIState<out T> {

    data object Loading: UIState<Nothing>()
    class Error(val message: String, val error: NetworkError): UIState<Nothing>()
    class Success<out T>(val data: T): UIState<T>()
}
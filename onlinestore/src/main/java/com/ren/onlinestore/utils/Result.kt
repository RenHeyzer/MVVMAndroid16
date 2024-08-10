package com.ren.onlinestore.utils

sealed class Result<out T> {

    class Success<out T>(val data: T): Result<T>()
    class Error(val exception: Throwable): Result<Nothing>()
}

fun <T> Result<T>.handleAsUIState(errorMessage: (error: NetworkError) -> String) = when (this) {
    is Result.Error -> UIState.Error(errorMessage(exception.asNetworkError()), exception.asNetworkError())
    is Result.Success -> UIState.Success(data)
}
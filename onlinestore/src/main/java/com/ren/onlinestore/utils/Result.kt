package com.ren.onlinestore.utils

sealed class Result<out T> {

    class Success<T>(val data: T): Result<T>()
    class Error(val exception: NetworkError): Result<Nothing>()
}
package com.ren.onlinestore.utils

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun Throwable.asNetworkError() = when (this) {
    is HttpException -> {
        when (this.code()) {
            HttpCode.NOT_FOUND.code ->
                NetworkError.NotFound(
                    this.message()
                )

            HttpCode.BAD_REQUEST.code ->
                NetworkError.BadRequest(
                    this.message()
                )

            HttpCode.UNAUTHORIZED.code ->
                NetworkError.UnAuthorized(
                    this.message()
                )

            HttpCode.INTERNAL_SEVER_ERROR.code ->
                NetworkError.InternalServerError(
                    this.message()
                )

            else ->
                NetworkError.Unknown(this.message())
        }
    }

    is ConnectException -> NetworkError.Connect(this.message ?: "Unknown error!")

    is UnknownHostException ->
        NetworkError.NetworkConnection(this.message ?: "Unknown error!")

    is SocketTimeoutException ->
        NetworkError.Timeout(this.message ?: "Unknown error!")

    else -> {
        NetworkError.UnExpected(
            this.message ?: "Unknown error!"
        )
    }
}
package com.ren.onlinestore.utils

sealed class NetworkError(override val message: String) : Exception() {
    data class NetworkConnection(override val message: String) : NetworkError(message)
    data class Timeout(override val message: String) : NetworkError(message)
    data class BadRequest(override val message: String) : NetworkError(message)
    data class UnAuthorized(override val message: String) : NetworkError(message)
    data class InternalServerError(override val message: String) : NetworkError(message)
    data class NotFound(override val message: String) : NetworkError(message)
    data class UnExpected(override val message: String): NetworkError(message)
    data class Unknown(override val message: String): NetworkError(message)
}
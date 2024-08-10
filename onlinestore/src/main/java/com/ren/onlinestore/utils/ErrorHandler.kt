package com.ren.onlinestore.utils

import android.app.Application
import com.ren.onlinestore.R

class ErrorHandler(private val application: Application) {

    fun handleError(error: NetworkError) = when (error) {
        is NetworkError.BadRequest -> error.message
        is NetworkError.InternalServerError -> application.getString(R.string.internal_server_error)
        is NetworkError.NetworkConnection -> application.getString(R.string.network_connection_error)
        is NetworkError.NotFound -> application.getString(R.string.not_found_error)
        is NetworkError.Timeout -> application.getString(R.string.timeout_error)
        is NetworkError.Connect -> application.getString(R.string.connect_error_message)
        is NetworkError.UnAuthorized -> application.getString(R.string.unauthorized_error)
        is NetworkError.UnExpected -> application.getString(R.string.unexpected_error)
        is NetworkError.Unknown -> application.getString(R.string.unknown_error)
    }
}
package com.ren.onlinestore.utils

enum class HttpCode(val code: Int) {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SEVER_ERROR(500)
}
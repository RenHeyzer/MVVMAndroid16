package com.ren.onlinestore.data.repositories

import com.ren.onlinestore.models.User
import com.ren.onlinestore.utils.Result

interface AuthenticationRepository {

    fun signUpWithEmailAndPassword(email: String, password: String): Result<User>
}
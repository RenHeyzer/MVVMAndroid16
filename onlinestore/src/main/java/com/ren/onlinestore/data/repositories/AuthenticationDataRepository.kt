package com.ren.onlinestore.data.repositories

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ren.onlinestore.models.User
import com.ren.onlinestore.utils.Result

class AuthenticationDataRepository : AuthenticationRepository {

    override fun signUpWithEmailAndPassword(email: String, password: String): Result<User> {
        val authTask = Firebase.auth.createUserWithEmailAndPassword(email, password)
        return if (authTask.isSuccessful && authTask.result != null) {
            try {
                val user = checkNotNull(authTask.result.user)
                user.sendEmailVerification()
                val additionalUserInfo = checkNotNull(authTask.result.additionalUserInfo)
                Result.Success(
                    User(
                        id = user.uid,
                        username = checkNotNull(additionalUserInfo.username),
                        email = email,
                    )
                )
            } catch (exception: IllegalStateException) {
                exception.printStackTrace()
                Result.Error(exception)
            }
        } else {
            Result.Error(authTask.exception!!)
        }
    }
}
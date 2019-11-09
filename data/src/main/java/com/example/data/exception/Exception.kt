package com.example.data.exception

import com.example.domain.exception.BusinessLogicException
import com.example.domain.exception.ServerException
import io.reactivex.Single
import retrofit2.Response



fun <T> request(call: Single<Response<T>>): Single<T> {
    return call.flatMap { response ->
        if (response.isSuccessful) {
            Single.just(response.body())
        } else {
            if (response.code() == 401) {
                Single.error<T>(ServerException("Ваша сессия закончилась!"))
            } else {
                Single.error<T>(ServerException("Произошла непредвиденная ошибка..."))
            }
        }
    }
}

fun handleError(error: Throwable, callback: (String, String) -> Unit) {
    when (error) {
        is BusinessLogicException -> callback.invoke(error.title, error.message!!)
        is ServerException -> callback.invoke("Ooops..", error.message!!)
        else -> callback("Ooops..", "Ошибка которая не описана")
    }
}
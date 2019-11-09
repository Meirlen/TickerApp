package com.example.data.remote


import com.example.gateway.entity.*
import io.reactivex.Single
import retrofit2.Response

import retrofit2.http.*


interface ApiService {

    @GET("/v1/ticker/")
    fun getCurrencies(): Single<Response<List<Currency>>>


}
package com.example.domain.repository


import com.example.domain.interactor.GetCurrenciesUseCase
import com.example.gateway.entity.*
import io.reactivex.Single

interface TickerRepository {
    fun getCurrencies(): Single<ArrayList<Currency>>
}
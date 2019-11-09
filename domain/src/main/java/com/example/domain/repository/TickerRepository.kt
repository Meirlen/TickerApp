package com.example.domain.repository
import com.example.domain.interactor.SaveCurrencyUseCase
import com.example.gateway.entity.*
import io.reactivex.Completable
import io.reactivex.Single

interface TickerRepository {
    fun getCurrenciesFromRemote(): Single<List<Currency>>
    fun getCurrenciesFromDb(): Single<List<Currency>>
    fun saveCurrencies(params: SaveCurrencyUseCase.Params): Completable

}
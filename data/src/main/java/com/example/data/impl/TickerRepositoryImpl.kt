package com.example.data.impl

import com.example.data.exception.request
import com.example.data.remote.ApiService
import com.example.domain.interactor.SaveCurrencyUseCase
import com.example.domain.repository.TickerRepository
import com.example.gateway.dao.CurrencyDao
import com.example.gateway.entity.*
import io.reactivex.Completable
import io.reactivex.Single

class TickerRepositoryImpl(
    private val api: ApiService,
    private val currencyDao: CurrencyDao
) : TickerRepository {


    override fun getCurrenciesFromDb(): Single<List<Currency>> = currencyDao.findAll()

    override fun getCurrenciesFromRemote(): Single<List<Currency>> = request(api.getCurrencies())

    override fun saveCurrencies(params: SaveCurrencyUseCase.Params): Completable =
        currencyDao.insert(params.currencyList)

}
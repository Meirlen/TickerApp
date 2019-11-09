package com.example.domain.interactor

import com.example.domain.base.SingleUseCase
import com.example.domain.repository.TickerRepository
import com.example.gateway.entity.Currency
import io.reactivex.Single
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(private val mRepository: TickerRepository) :
    SingleUseCase<ArrayList<Currency>, Any>() {

    override fun buildUseCaseSingle(params: Any): Single<ArrayList<Currency>> {
        return mRepository.getCurrencies()
    }

}
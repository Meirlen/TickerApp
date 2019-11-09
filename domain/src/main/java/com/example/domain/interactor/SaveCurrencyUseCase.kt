package com.example.domain.interactor
import com.example.domain.base.CompletableUseCase
import com.example.domain.repository.TickerRepository
import com.example.gateway.entity.Currency
import io.reactivex.Completable
import javax.inject.Inject

class SaveCurrencyUseCase @Inject constructor(private val tickerRepository: TickerRepository) :
    CompletableUseCase<SaveCurrencyUseCase.Params>() {

    override fun buildUseCaseCompletable(params: Params): Completable =
        tickerRepository.saveCurrencies(params)

    data class Params(
        val currencyList: List<Currency>
    )
}
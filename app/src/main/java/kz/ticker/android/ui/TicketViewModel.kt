package kz.ticker.android.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.GetCurrenciesUseCase
import com.example.domain.interactor.SaveCurrencyUseCase
import com.example.gateway.entity.*
import kz.ticker.android.vo.Resource


open class TicketViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
    private val saveCurrencyUseCase: SaveCurrencyUseCase

) : ViewModel() {


    var currencyLiveData: MutableLiveData<Resource<List<Currency>>> = MutableLiveData()
    val eventLiveData: MutableLiveData<String> = MutableLiveData()


    fun getCurrencies(fromRemote: Boolean) {

        currencyLiveData.value = Resource.loading(null)
        getCurrenciesUseCase.execute(
            { currencies ->
                if (fromRemote) {
                    saveOrdersToLocalDb(currencies)

                } else if (!fromRemote && currencies.isEmpty()) {
                    getCurrencies(true)
                }
                currencyLiveData.value = Resource.success(currencies)
            },
            {
                currencyLiveData.value = Resource.error(error = it)

            }, GetCurrenciesUseCase.Params(fromRemote)
        )
    }


    private fun saveOrdersToLocalDb(orders: List<Currency>) {
        saveCurrencyUseCase.execute(
            {
                eventLiveData.value = "Data successfully saved"
            },
            {
                currencyLiveData.value = Resource.error(it.message.toString(), null)

            }, SaveCurrencyUseCase.Params(orders)
        )
    }
}


package kz.ticker.android.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.GetCurrenciesUseCase
import com.example.gateway.entity.*
import kz.ticker.android.vo.Resource


open class TicketViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase

) : ViewModel() {


    var uiEvent: MutableLiveData<Resource<List<Currency>>> = MutableLiveData()


    fun getCurrencies() {

        uiEvent.value = Resource.loading(null)
        getCurrenciesUseCase.execute(
            {
                uiEvent.value = Resource.success(it)
            },
            {
                uiEvent.value = Resource.error(error = it)

            }, Any()
        )
    }

}


package kz.ticker.android.di

import com.example.data.impl.*

import com.example.domain.interactor.GetCurrenciesUseCase

import com.example.domain.repository.*

import kz.ticker.android.ui.TicketViewModel

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val archModule = module {
    module("repository") {

        factory {
            TickerRepositoryImpl(get()) as TickerRepository
        }
        factory {
            GetCurrenciesUseCase(get())
        }

        module("viewModel") {

            viewModel {
                TicketViewModel(get())
            }

        }
    }

}



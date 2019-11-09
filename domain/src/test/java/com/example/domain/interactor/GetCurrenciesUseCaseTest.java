package com.example.domain.interactor;

import com.example.domain.repository.TickerRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class GetCurrenciesUseCaseTest {

    private GetCurrenciesUseCase getCurrenciesUseCase;

    @Mock
    private TickerRepository tickerRepository;


    @Before
    public void setUp() throws Exception {

        getCurrenciesUseCase = new GetCurrenciesUseCase(tickerRepository);

    }

    @Test
    public void shoulDelegateCallToRepository() {
        getCurrenciesUseCase.buildUseCaseSingle(tickerRepository);
        Mockito.verify(tickerRepository).getCurrencies();

    }
}
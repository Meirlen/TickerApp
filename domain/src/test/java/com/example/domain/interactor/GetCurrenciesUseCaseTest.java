package com.example.domain.interactor;

import com.example.domain.repository.TickerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


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
    public void shouldDelegateCallToRepositoryFromRemote() {
        GetCurrenciesUseCase.Params params = new GetCurrenciesUseCase.Params();
        params.setFromRemote(true);
        getCurrenciesUseCase.buildUseCaseSingle(params);
        Mockito.verify(tickerRepository).getCurrenciesFromRemote();

    }

    @Test
    public void shouldDelegateCallToRepositoryFromLocal() {
        GetCurrenciesUseCase.Params params = new GetCurrenciesUseCase.Params();
        params.setFromRemote(false);
        getCurrenciesUseCase.buildUseCaseSingle(params);
        Mockito.verify(tickerRepository).getCurrenciesFromDb();

    }
}
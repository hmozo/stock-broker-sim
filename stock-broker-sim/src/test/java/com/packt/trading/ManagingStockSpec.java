package com.packt.trading;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.packt.trading.dto.Stock;
import com.packt.trading.services.MarketWatcher;
import com.packt.trading.services.Portfolio;
import com.packt.trading.services.impl.MarketWatcherImpl;
import com.packt.trading.services.impl.PortfolioImpl;

class ManagingStockSpec {
	
	@Mock
	MarketWatcher marketWatcher;
	
	Portfolio portfolio;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		portfolio= new PortfolioImpl();
	}
	
	

	@Test
	void givenMockMarketWatcherWhenGetquoteThenNotNull() {
		Stock uvsityCorp= new Stock("UV", "Uvsity Corporation", new BigDecimal("100.00"));
		when(marketWatcher.getQuote(anyString())).thenReturn(uvsityCorp);
		
		assertThat(marketWatcher.getQuote("UV")).isNotNull();
	}
	

	@Test
	void whenBuy2StocksThenAvgPriceMatches() {
		Stock uv= new Stock("UV", "Uvsity Corporation", new BigDecimal("100.00"));
		portfolio.buy(uv);
		uv= new Stock("UV", "Uvsity Corporation", new BigDecimal("150.00"));
		portfolio.buy(uv);
		Stock uv2= new Stock("UV2", "Uvsity Corporation2", new BigDecimal("200.00"));
		portfolio.buy(uv2);

		assertThat(portfolio.getAvgPrice(uv)).isEqualByComparingTo(new BigDecimal("125.00"));
	}
	
	

}

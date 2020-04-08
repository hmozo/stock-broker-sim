package com.packt.trading.services;

import com.packt.trading.dto.Stock;

public interface MarketWatcher {
	Stock getQuote(String symbol);
}

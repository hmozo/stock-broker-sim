package com.packt.trading.services;

import java.math.BigDecimal;

import com.packt.trading.dto.Stock;

public interface Portfolio {
	void buy(Stock stock);
	void sell(Stock stock);
	BigDecimal getAvgPrice(Stock stock);
}

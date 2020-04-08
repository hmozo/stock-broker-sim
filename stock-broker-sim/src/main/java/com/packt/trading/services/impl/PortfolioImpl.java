package com.packt.trading.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.packt.trading.dto.Stock;
import com.packt.trading.services.Portfolio;

public class PortfolioImpl implements Portfolio {

	Map<String, List<Stock>> stocksMap;
	
	public PortfolioImpl() {
		this.stocksMap= new HashMap<String, List<Stock>>();
	}
	
	@Override
	public void buy(Stock stock) {
		List<Stock> listStocks=
				this.stocksMap.get(stock.getSymbol())==null?
						new ArrayList<>():
						this.stocksMap.get(stock.getSymbol());	
		listStocks.add(stock);
		this.stocksMap.put(stock.getSymbol(), listStocks);
	}

	@Override
	public void sell(Stock stock) {

	}

	@Override
	public BigDecimal getAvgPrice(Stock stock) {
		List<Stock> stockList= this.stocksMap.get(stock.getSymbol());
		BigDecimal sumPrices= stockList.stream()
			.map(Stock::getPrice)
			.reduce(BigDecimal.ZERO, (p1,p2)->p1.add(p2));
					
		return sumPrices.divide(new BigDecimal(stockList.size()));
	}
	
	

}

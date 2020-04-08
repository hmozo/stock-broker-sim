package com.packt.trading.dto;

import java.math.BigDecimal;

public class Stock {
	 private String symbol;
	    private String name;
	    private BigDecimal price;

	    public Stock(String symbol, String name, BigDecimal price) {
	        this.symbol = symbol;
	        this.name = name;
	        this.price = price;
	    }

	    public Stock(){
	        System.out.println("Stock constructor no parameters");
	    }

	    public String getSymbol() {
	        return symbol;
	    }

	    public String getName() {
	        return name;
	    }

	    public BigDecimal getPrice() {
	        System.out.println("getPrice");
	        return price;
	    }

	    public void updatePrice(BigDecimal newPrice) {
	        this.price = newPrice;
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Stock other = (Stock) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (symbol == null) {
				if (other.symbol != null)
					return false;
			} else if (!symbol.equals(other.symbol))
				return false;
			return true;
		}
	    
	    
}

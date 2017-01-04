package demo.app.demoapp.data.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Money {
	private Double value;
	private Currency currency;
	
	private static final NumberFormat FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);

	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Money(Double value) {
		super();
		this.value = value;
		this.currency = Currency.USD;
	}

	public Money(Double value, Currency ccy) {
		super();
		this.value = value;
		this.currency = ccy;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Money [value=" + FORMATTER.format(value) + ", currency=" + currency + "]";
	}
	
}

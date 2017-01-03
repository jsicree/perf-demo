package demo.app.demoapp.data.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Money {
	private Double value;
	
	private static final NumberFormat FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);

	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Money(Double value) {
		super();
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return FORMATTER.format(value);
	}
	
	
	
}

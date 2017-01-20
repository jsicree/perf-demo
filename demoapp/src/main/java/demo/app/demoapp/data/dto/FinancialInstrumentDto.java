package demo.app.demoapp.data.dto;

import javax.persistence.Column;

public class FinancialInstrumentDto {

	
	private Long id;
	private String symbol;
	private String exchange;
	
	public FinancialInstrumentDto() {
		// TODO Auto-generated constructor stub
	}

	public FinancialInstrumentDto(Long id, String symbol, String exchange) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.exchange = exchange;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@Override
	public String toString() {
		return "FinancialInstrumentDto [id=" + id + ", symbol=" + symbol + ", exchange=" + exchange + "]";
	}
	
}

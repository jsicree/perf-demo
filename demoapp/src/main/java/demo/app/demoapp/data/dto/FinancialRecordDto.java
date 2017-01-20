package demo.app.demoapp.data.dto;

import java.util.Date;

public class FinancialRecordDto {

	private Long id;
	private Long financialInstrumentId;
	private String symbol;
	private String exchange;
	private Date date;
	private Double openPrice;
	private Double closePrice;
	private Long volume;
	
	
	public FinancialRecordDto() {
		// TODO Auto-generated constructor stub
	}


	public FinancialRecordDto(Long id, Long financialInstrumentId, String symbol, String exchange, Date date,
			Double openPrice, Double closePrice, Long volume) {
		super();
		this.id = id;
		this.financialInstrumentId = financialInstrumentId;
		this.symbol = symbol;
		this.exchange = exchange;
		this.date = date;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.volume = volume;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getFinancialInstrumentId() {
		return financialInstrumentId;
	}


	public void setFinancialInstrumentId(Long financialInstrumentId) {
		this.financialInstrumentId = financialInstrumentId;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getOpenPrice() {
		return openPrice;
	}


	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}


	public Double getClosePrice() {
		return closePrice;
	}


	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}


	public Long getVolume() {
		return volume;
	}


	public void setVolume(Long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "FinancialRecordDto [id=" + id + ", financialInstrumentId=" + financialInstrumentId + ", symbol="
				+ symbol + ", exchange=" + exchange + ", date=" + date + ", openPrice=" + openPrice + ", closePrice="
				+ closePrice + ", volume=" + volume + "]";
	}
	
}

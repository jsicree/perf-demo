package demo.app.demoweb.mvc.data;

import java.util.List;

public class FinancialRecordRequest {
	private List<String> tickerSymbols;
	private String date;
	
	public FinancialRecordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinancialRecordRequest(List<String> tickerSymbols, String date) {
		super();
		this.tickerSymbols = tickerSymbols;
		this.date = date;
	}

	public List<String> getTickerSymbols() {
		return tickerSymbols;
	}

	public void setTickerSymbols(List<String> tickerSymbols) {
		this.tickerSymbols = tickerSymbols;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FinancialRecordRequest [tickerSymbols=" + tickerSymbols + ", date=" + date + "]";
	}
}

package demo.app.demoapp.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A stock.
 * 
 * @author joseph_sicree
 *
 */
@Entity(name="INSTRUMENT")
public class FinancialInstrument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="SYMBOL")
	private String symbol;

	@Column(name="EXCHANGE")
	private String exchange;
	
	
	public FinancialInstrument() {
	}

	public FinancialInstrument(Long id, String symbol, String exchange) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.exchange = exchange;
	}

	public FinancialInstrument(String symbol, String exchange) {
		super();
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
		return "FinancialInstrument [id=" + id + ", symbol=" + symbol + ", exchange=" + exchange + "]";
	}
	
}

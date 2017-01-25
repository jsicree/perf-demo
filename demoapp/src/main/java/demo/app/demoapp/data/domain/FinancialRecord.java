package demo.app.demoapp.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The financial information for a stock on a specific date.
 * 
 * @author joseph_sicree
 *
 */
@Entity(name="INSTRUMENT_INFO")
public class FinancialRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="INSTRUMENT_ID")
	private FinancialInstrument financialInstrument;

	@Column(name="DATE")
	private Date date;

	@Column(name="OPEN_PRICE")
	private Double openPrice;

	@Column(name="CLOSE_PRICE")
	private Double closePrice;

	@Column(name="VOLUME")
	private Long volume;
	
	public FinancialRecord() {
	}

	public FinancialRecord(Long id, FinancialInstrument financialInstrument, Date date, Double openPrice,
			Double closePrice, Long volume) {
		super();
		this.id = id;
		this.financialInstrument = financialInstrument;
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

	public FinancialInstrument getFinancialInstrument() {
		return financialInstrument;
	}

	public void setFinancialInstrument(FinancialInstrument financialInstrument) {
		this.financialInstrument = financialInstrument;
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
		return "FinancialRecord [id=" + id + ", financialInstrument=" + financialInstrument + ", date=" + date
				+ ", openPrice=" + openPrice + ", closePrice=" + closePrice + ", volume=" + volume + "]";
	}
	
}

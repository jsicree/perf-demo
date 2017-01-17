package demo.app.demoapp.data.dto;

import java.util.Date;
import java.util.Map;

public class InterestResult {
	private String accountIdentifier;
	private Double interestRate;
	private Date startDate;
	private Integer intervals;
	private Frequency frequency;
	private Money startBalance;
	private Money endBalance;
	private Map<Date, Money> results;
	
	public InterestResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getIntervals() {
		return intervals;
	}

	public void setIntervals(Integer intervals) {
		this.intervals = intervals;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public Money getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(Money startBalance) {
		this.startBalance = startBalance;
	}

	public Money getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(Money endBalance) {
		this.endBalance = endBalance;
	}

	public Map<Date, Money> getResults() {
		return results;
	}

	public void setResults(Map<Date, Money> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "InterestResult [accountIdentifier=" + accountIdentifier + ", interestRate=" + interestRate
				+ ", startDate=" + startDate + ", intervals=" + intervals + ", frequency=" + frequency
				+ ", startBalance=" + startBalance + ", endBalance=" + endBalance + "]";
	}

	
	
}

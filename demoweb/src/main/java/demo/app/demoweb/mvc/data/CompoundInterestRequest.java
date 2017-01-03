package demo.app.demoweb.mvc.data;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;

public class CompoundInterestRequest {
	private List<AccountInfo> accounts;
	private Date startDate;
	private Integer intervals;
	private Frequency frequency;
	private Boolean includeBreakdowns;
	public CompoundInterestRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompoundInterestRequest(List<AccountInfo> accounts, Date startDate, Integer intervals, Frequency frequency,
			Boolean includeBreakdowns) {
		super();
		this.accounts = accounts;
		this.startDate = startDate;
		this.intervals = intervals;
		this.frequency = frequency;
		this.includeBreakdowns = includeBreakdowns;
	}
	public List<AccountInfo> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountInfo> accounts) {
		this.accounts = accounts;
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
	public Boolean getIncludeBreakdowns() {
		return includeBreakdowns;
	}
	public void setIncludeBreakdowns(Boolean includeBreakdowns) {
		this.includeBreakdowns = includeBreakdowns;
	}
	@Override
	public String toString() {
		return "CompoundInterestRequest [accounts=" + accounts + ", startDate=" + startDate + ", intervals=" + intervals
				+ ", frequency=" + frequency + ", includeBreakdowns=" + includeBreakdowns + "]";
	}
	
	
}

package demo.app.demoapp.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;
import demo.app.demoapp.data.domain.Money;
import demo.app.demoapp.data.domain.InterestResult;

public class CompoundInterestTask implements Callable<InterestResult> {

	private AccountInfo a;
	private Date startDate;
	private Integer intervals;
	private ArrayList<Date> intervalList;
	private Frequency freq;
	private Boolean includeBreakdowns;
	
	public CompoundInterestTask() {
		// TODO Auto-generated constructor stub
	}
	
	public CompoundInterestTask(AccountInfo a, Date startDate, Integer intervals, ArrayList<Date> intervalList,
			Frequency freq, Boolean includeBreakdowns) {
		super();
		this.a = a;
		this.startDate = startDate;
		this.intervals = intervals;
		this.intervalList = intervalList;
		this.freq = freq;
		this.includeBreakdowns = includeBreakdowns;
	}



	public InterestResult call() throws Exception {
		InterestResult result = new InterestResult();
		result.setAccountIdentifier(a.getIdentifier());
		result.setStartDate(startDate);
		result.setIntervals(intervals);
		result.setStartBalance(a.getBalance());
		result.setFrequency(freq);
		result.setInterestRate(a.getRate());

		Map<Date, Money> res = new HashMap<Date, Money>();
		Double currentBalance = a.getBalance().getValue();
		res.put(startDate, a.getBalance());

		for (Date d : intervalList) {
			Double interest = currentBalance * a.getRate();
			currentBalance += interest;
			res.put(d, new Money(currentBalance));
			long delay = new Double(Math.random() * 50).longValue();
			// log.info("Delay (ms): " + delay);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		result.setEndBalance(new Money(currentBalance));
		if (includeBreakdowns) {
			result.setResults(res);
		} else {
			result.setResults(null);
		}
		return result;
	}

}

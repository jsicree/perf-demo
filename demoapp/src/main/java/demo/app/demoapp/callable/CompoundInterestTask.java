package demo.app.demoapp.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import demo.app.demoapp.data.dto.AccountInfo;
import demo.app.demoapp.data.dto.Frequency;
import demo.app.demoapp.data.dto.InterestResult;
import demo.app.demoapp.data.dto.Money;

/**
 * Wraps an <code>InterestResult</code> in a <code>Callable</code>
 * for use in the asynchronous service implementation.
 * 
 * @author joseph_sicree
 *
 */
public class CompoundInterestTask implements Callable<InterestResult> {

	private AccountInfo a;
	private Date startDate;
	private Integer intervals;
	private ArrayList<Date> intervalList;
	private Frequency freq;
	private Boolean includeBreakdowns;
	private Integer computeDelay;
	
	/**
	 * Default ctor
	 */
	public CompoundInterestTask() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param a
	 * @param startDate
	 * @param intervals
	 * @param intervalList
	 * @param freq
	 * @param includeBreakdowns
	 * @param computeDelay
	 */
	public CompoundInterestTask(AccountInfo a, Date startDate, Integer intervals, ArrayList<Date> intervalList,
			Frequency freq, Boolean includeBreakdowns, Integer computeDelay) {
		super();
		this.a = a;
		this.startDate = startDate;
		this.intervals = intervals;
		this.intervalList = intervalList;
		this.freq = freq;
		this.includeBreakdowns = includeBreakdowns;
		this.computeDelay = computeDelay;
	}

	/**
	 * Compute the compound interest for an account.
	 * 
	 * @return The result of the calculation.
	 */
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
			
			// The delay is a random "pause" in processing to 
			// simulate other processing occurring behind the 
			// scenes. The seed for the delay is set in a 
			// properties file.
			long delay = new Double(Math.random() * computeDelay).longValue();
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

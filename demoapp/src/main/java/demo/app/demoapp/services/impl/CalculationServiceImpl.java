package demo.app.demoapp.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import demo.app.demoapp.callable.CompoundInterestTask;
import demo.app.demoapp.data.dto.AccountInfo;
import demo.app.demoapp.data.dto.Frequency;
import demo.app.demoapp.data.dto.InterestResult;
import demo.app.demoapp.data.dto.Money;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.ServiceException;

/**
 * Implementation of the calculation service.
 * 
 * @author joseph_sicree
 *
 */
@Service
public class CalculationServiceImpl implements CalculationService {

	protected final static Logger log = LoggerFactory.getLogger(CalculationServiceImpl.class);

	@Autowired
	protected ThreadPoolTaskExecutor taskExecutor;

	// A seed for a random delay in the processing methods.
	protected Integer computeDelay; 

	/**
	 * Default ctor
	 */
	public CalculationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param computeDelay
	 */
	public CalculationServiceImpl(Integer computeDelay) {
		super();
		this.computeDelay = computeDelay;
	}

	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.CalculationService#calculateCompoundInterest(java.util.List, java.util.Date, java.lang.Integer, demo.app.demoapp.data.dto.Frequency, java.lang.Boolean)
	 */
	public List<InterestResult> calculateCompoundInterest(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException {
		Long startTime = System.currentTimeMillis();
		List<InterestResult> resultList = new ArrayList<InterestResult>();

		ArrayList<Date> intervalList = createIntervals(startDate, intervals, freq);

		for (AccountInfo a : accounts) {
			log.info("Computing the compound interest for account " + a.getIdentifier());
			resultList.add(computeInterest(a, startDate, intervals, intervalList, freq, includeBreakdowns));
		}
		log.info("[PERF] num_accounts, intervals, frequency, elapsed_time_ms: " + accounts.size() + ", " + intervals
				+ ", " + freq + ", " + (System.currentTimeMillis() - startTime));
		return resultList;
	}

	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.CalculationService#calculateCompoundInterestAsync(java.util.List, java.util.Date, java.lang.Integer, demo.app.demoapp.data.dto.Frequency, java.lang.Boolean)
	 */
	public List<InterestResult> calculateCompoundInterestAsync(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException {
		Long startTime = System.currentTimeMillis();
		List<InterestResult> resultList = new ArrayList<InterestResult>();

		log.info("TaskExecutor corePoolSize: " + taskExecutor.getCorePoolSize());
		log.info("TaskExecutor maxPoolSize: " + taskExecutor.getMaxPoolSize());
		log.info("TaskExecutor poolSize: " + taskExecutor.getPoolSize());
		log.info("TaskExecutor threadNamePrefix: " + taskExecutor.getThreadNamePrefix());

		ArrayList<Date> intervalList = createIntervals(startDate, intervals, freq);

		ArrayList<CompoundInterestTask> taskList = new ArrayList<CompoundInterestTask>();

		try {
			for (AccountInfo a : accounts) {
				log.info("Creating compound interest task for account " + a.getIdentifier());
				taskList.add(new CompoundInterestTask(a, startDate, intervals, intervalList, freq, includeBreakdowns, computeDelay));
			}

			try {
				log.info("Calling invokeAll to execute all tasks.");
				List<Future<InterestResult>> asyncResult = taskExecutor.getThreadPoolExecutor().invokeAll(taskList);
				for (Future<InterestResult> result : asyncResult) {
					if (result.isDone()) {
						resultList.add(result.get());
					}
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("[PERF] num_accounts, intervals, frequency, elapsed_time_ms: " + accounts.size() + ", " + intervals
				+ ", " + freq + ", " + (System.currentTimeMillis() - startTime));
		return resultList;
	}

	/**
	 * Compute the compound interest for an account.
	 * 
	 * @param a
	 * @param startDate
	 * @param intervals
	 * @param intervalList
	 * @param freq
	 * @param includeBreakdowns
	 * 
	 * @return A <code>InterestResult</code>
	 */
	private InterestResult computeInterest(final AccountInfo a, final Date startDate, final Integer intervals,
			final ArrayList<Date> intervalList, final Frequency freq, final Boolean includeBreakdowns) {
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

		//log.info("CompoundInterest delay (ms): " + computeDelay);

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

	/**
	 * Create a list of dates based on the frequency and number of intervals.
	 * 
	 * @param startDate
	 * @param intervals
	 * @param freq
	 * 
	 * @return A <code>List</code> of <code>Date</code>
	 */
	private ArrayList<Date> createIntervals(final Date startDate, final Integer intervals, final Frequency freq) {
		ArrayList<Date> result = new ArrayList<Date>();

		Calendar startCal = GregorianCalendar.getInstance();
		startCal.setTime(startDate);

		result.add(startCal.getTime());
		for (int i = 0; i < intervals; i++) {
			if (freq.equals(Frequency.YEARLY)) {
				startCal.add(Calendar.YEAR, 1);
			} else if (freq.equals(Frequency.MONTHLY)) {
				startCal.add(Calendar.MONTH, 1);
			}
			result.add(startCal.getTime());
		}

		return result;
	}

}

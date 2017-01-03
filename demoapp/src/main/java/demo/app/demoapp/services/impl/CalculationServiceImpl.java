package demo.app.demoapp.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;
import demo.app.demoapp.data.domain.InterestResult;
import demo.app.demoapp.data.domain.Money;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.ServiceException;

@Service
public class CalculationServiceImpl implements CalculationService {

	protected final static Logger log = LoggerFactory.getLogger(CalculationServiceImpl.class);

	public CalculationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<InterestResult> calculateCompoundInterest(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException {
		Long startTime = System.currentTimeMillis();
		List<InterestResult> resultList = new ArrayList<InterestResult>();

		ArrayList<Date> intervalList = createIntervals(startDate, intervals, freq);

		for (AccountInfo a : accounts) {
			resultList.add(computeInterest(a, startDate, intervals, intervalList, freq, includeBreakdowns));
		}
		log.info("[PERF] num_accounts, intervals, frequency, elapsed_time_ms: " + accounts.size() + ", " + 
				intervals + ", " + 
				freq + ", " +				
				(System.currentTimeMillis() - startTime));
		return resultList;
	}

	private InterestResult computeInterest(final AccountInfo a, final Date startDate,
			final Integer intervals, final ArrayList<Date> intervalList, final Frequency freq, final Boolean includeBreakdowns) {
		InterestResult result = new InterestResult();
		result.setAccountIdentifier(a.getIdentifier());
		result.setStartDate(startDate);
		result.setIntervals(intervals);
		result.setStartBalance(new Money(a.getBalance()));
		result.setFrequency(freq);
		result.setInterestRate(a.getRate());

		Map<Date, Money> res = new HashMap<Date, Money>();
		Double currentBalance = a.getBalance();
		res.put(startDate, new Money(a.getBalance()));

		for (Date d : intervalList) {
			Double interest = currentBalance * a.getRate();
			currentBalance += interest;
			res.put(d, new Money(currentBalance));
			result.setEndBalance(new Money(currentBalance));
			long delay = new Double(Math.random() * 50).longValue(); 
			//log.info("Delay (ms): " + delay);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (includeBreakdowns) {
			result.setResults(res);			
		} else {
			result.setResults(null);
		}
		
		return result;

	}

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

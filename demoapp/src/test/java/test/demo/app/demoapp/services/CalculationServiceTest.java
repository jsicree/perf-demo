package test.demo.app.demoapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import demo.app.demoapp.AppConfig;
import demo.app.demoapp.data.domain.Account;
import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.AccountStatus;
import demo.app.demoapp.data.domain.AccountType;
import demo.app.demoapp.data.domain.Frequency;
import demo.app.demoapp.data.domain.InterestResult;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.ServiceException;

public class CalculationServiceTest {

	protected final static Logger log = LoggerFactory.getLogger(CalculationServiceTest.class); 

	private static CalculationService calcService;
	private static AbstractApplicationContext context;

	private static final AccountInfo[] YEARLY_ACCOUNT_ARRAY = { 
			new AccountInfo("XYZ-001", new Double(5300.40), new Double(0.0200)), 	
			new AccountInfo("ABC-392", new Double(10500.00), new Double(0.0200)) 	
	};
	
	private static final AccountInfo[] MONTHLY_ACCOUNT_ARRAY = { 
			new AccountInfo("XYZ-001", new Double(5300.40), new Double(0.0020)), 	
			new AccountInfo("ABC-392", new Double(10500.00), new Double(0.0020)) 	
	};
	
	@BeforeClass
	public static void setup() {

		context = new AnnotationConfigApplicationContext(AppConfig.class);		
		calcService = (CalculationService) context
				.getBean("calculationService");				
	}
		
	@Test
	public void testCompoundInterestYearlyCalculation() {

		log.info(">> Entering testCompoundInterestYearlyCalculation");
		List<InterestResult> results = new ArrayList<InterestResult>();

		Integer intervals = 10;
		Frequency freq = Frequency.YEARLY;
		String startDateStr = "05-27-2017";
		
		List<AccountInfo> accountList = new ArrayList<AccountInfo>();
		
		for (AccountInfo a : YEARLY_ACCOUNT_ARRAY) {
			accountList.add(a);			
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date startDate = null;
		try {
			startDate = sdf.parse(startDateStr);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			results = calcService.calculateCompoundInterest(accountList, startDate, intervals , freq, false);
			if (results != null) {
				for (InterestResult ir : results) {
					log.info(ir.toString());					
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		log.info("<< Leaving testCompoundInterestYearlyCalculation.");
	}

	@Test
	public void testCompoundInterestMonthlyCalculation() {

		log.info(">> Entering testCompoundInterestMonthlyCalculation");
		List<InterestResult> results = new ArrayList<InterestResult>();

		Integer intervals = 120;
		Frequency freq = Frequency.MONTHLY;
		String startDateStr = "05-27-2017";

		List<AccountInfo> accountList = new ArrayList<AccountInfo>();
		
		for (AccountInfo a : MONTHLY_ACCOUNT_ARRAY) {
			accountList.add(a);			
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date startDate = null;

		try {
			startDate = sdf.parse(startDateStr);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			results = calcService.calculateCompoundInterest(accountList, startDate, intervals, freq, false);
			if (results != null) {
				for (InterestResult ir : results) {
					log.info(ir.toString());					
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		log.info("<< Leaving testCompoundInterestMonthlyCalculation.");
	}
	
}

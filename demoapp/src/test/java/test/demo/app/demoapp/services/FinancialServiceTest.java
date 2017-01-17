package test.demo.app.demoapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import demo.app.demoapp.AppConfig;
import demo.app.demoapp.data.domain.FinancialInstrument;
import demo.app.demoapp.data.domain.FinancialRecord;
import demo.app.demoapp.data.jpa.JpaConfig;
import demo.app.demoapp.services.FinancialService;
import demo.app.demoapp.services.ServiceException;

public class FinancialServiceTest {

	protected final static Logger log = LoggerFactory.getLogger(FinancialServiceTest.class); 

	private final static String[] SYMBOL_ARRAY = {"AEA", "ABE"};
	
	private static FinancialService financialService;
	private static AbstractApplicationContext context;

	@BeforeClass
	public static void setup() {

		context = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class);		
		financialService = (FinancialService) context
				.getBean("financialService");				
	}
		
	@Test
	public void testGetAllFinancialInstruments() {

		log.info(">> Entering testGetAllFinancialInstruments");

		try {
			List<FinancialInstrument> resultList = new ArrayList<FinancialInstrument>();
			resultList = financialService.getAllFinancialInstruments();
			org.junit.Assert.assertNotNull("FinInst list was null", resultList);
			org.junit.Assert.assertNotEquals("FinInst list was empty", resultList.size(), 0);
			for (FinancialInstrument fi : resultList) {
				log.info(fi.toString());
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("<< Leaving testGetAllFinancialInstruments");
	}

	@Test
	public void testGetAllFinancialRecords() {

		log.info(">> Entering testGetAllFinancialRecords");

		try {
			List<FinancialRecord> resultList = new ArrayList<FinancialRecord>();
			resultList = financialService.getAllFinancialRecords();
			org.junit.Assert.assertNotNull("FinRec list was null", resultList);
			org.junit.Assert.assertNotEquals("FinRec list was empty", resultList.size(), 0);
			for (FinancialRecord fr : resultList) {
				log.info(fr.toString());
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("<< Leaving testGetAllFinancialRecords");
	}

	@Test
	public void testGetFinancialRecords() {

		log.info(">> Entering testGetFinancialRecords");

		List<String> symbolList = Arrays.asList(SYMBOL_ARRAY);
		try {
			List<FinancialRecord> resultList = new ArrayList<FinancialRecord>();
			resultList = financialService.getFinancialRecords(symbolList, null, null);
			org.junit.Assert.assertNotNull("FinRec list was null", resultList);
			org.junit.Assert.assertNotEquals("FinRec list was empty", resultList.size(), 0);
			for (FinancialRecord fr : resultList) {
				log.info(fr.toString());
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("<< Leaving testGetFinancialRecords");
	}
	
}

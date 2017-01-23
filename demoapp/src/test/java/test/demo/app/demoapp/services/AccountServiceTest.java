package test.demo.app.demoapp.services;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import demo.app.demoapp.AppConfig;
import demo.app.demoapp.data.dto.Account;
import demo.app.demoapp.data.jpa.JpaConfig;
import demo.app.demoapp.services.AccountService;
import demo.app.demoapp.services.ServiceException;

public class AccountServiceTest {

	protected final static Logger log = LoggerFactory.getLogger(AccountServiceTest.class); 

	private static AccountService accountService;
	private static AbstractApplicationContext context;

	private static final String[] IDENTIFIER_ARRAY = { "XYZ-001", "ABC-392"};
	private static final String BAD_IDENTIFIER = "BAD-IDENTIFIER";

	@BeforeClass
	public static void setup() {

		context = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class);		
		accountService = (AccountService) context
				.getBean("accountService");				
	}
		
	@Test
	public void testAccountMethods() {

		log.info(">> Entering testAccountMethods");

		log.info("Testing getAllAccounts().");
		ArrayList<Account> list;
		try {
			list = (ArrayList<Account>) accountService.getAllAccounts();
			if (list == null) {
				org.junit.Assert.fail("Test of getAllAccounts() failed.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			org.junit.Assert.fail("Test of getAllAccounts() failed: " + e.getLocalizedMessage());
		}

		log.info("Testing getAccountByIdentifier().");
		Account account;
		try {
			account = accountService.getAccountByIdentifier(IDENTIFIER_ARRAY[0]);
			if (account == null) {
				org.junit.Assert.fail("Test of getAccountByIdentifier() failed.");
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			org.junit.Assert.fail("Test of getAccountByIdentifier() failed: " + e.getLocalizedMessage());
		}


		log.info("Testing getAccountByIdentifier() (negative).");
		try {
			Account unknownAccount = accountService.getAccountByIdentifier(BAD_IDENTIFIER);
			if (unknownAccount != null) {
				org.junit.Assert.fail("Test of getAccountByIdentifier() (negative) failed.");
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			org.junit.Assert.fail("Test of getAccountByIdentifier() (negative) failed: " + e.getLocalizedMessage());
		}

		log.info("<< Leaving CustomerTest.");
	}

}

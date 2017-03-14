package test.demo.app.demoapp.services;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import demo.app.demoapp.AppConfig;
import demo.app.demoapp.data.jpa.JpaConfig;
import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;

public class MemoryServiceTest {

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceTest.class); 

	private static MemoryService memoryService;
	private static AbstractApplicationContext context;

	@BeforeClass
	public static void setup() {

		context = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class);		
		memoryService = (MemoryService) context
				.getBean("memoryService");				
	}
		
	@Test
	public void testOutOfMemoryViaBadKey() {

		log.info(">> Entering testOutOfMemoryViaBadKey");

		try {
			memoryService.populateBadKeyMap(new Integer(100), new Integer(10000));
			memoryService.populateBadKeyMap(new Integer(100), new Integer(10000));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("<< Leaving testOutOfMemoryViaBadKey");
	}

	@Test
	public void testOutOfMemoryViaGoodKey() {

		log.info(">> Entering testOutOfMemoryViaGoodKey");

		try {
			memoryService.populateGoodKeyMap(new Integer(100), new Integer(10000));
			memoryService.populateGoodKeyMap(new Integer(100), new Integer(10000));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("<< Leaving testOutOfMemoryViaGoodKey");
	}
	
}

package demo.app.demoweb.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.app.demoapp.data.domain.Account;
import demo.app.demoapp.services.AccountService;
import demo.app.demoapp.services.ServiceException;
import demo.app.demoweb.mvc.data.BandDto;
import demo.app.demoweb.mvc.data.Genre;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("service")
public class ServiceController {

	@Autowired
	private AccountService accountService;

	protected final static Logger log = LoggerFactory
			.getLogger(ServiceController.class);
	
	@RequestMapping(value = "/getAllAccounts", method = RequestMethod.GET, produces = "application/json")
	public List<Account> getAllAccounts() {

		log.debug("Calling JSON service getAllAccounts()");

		List<Account> resultList = new ArrayList<Account>();
		
		try {
			resultList = accountService.getAllAccounts();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@RequestMapping(value = "/getAllBands", method = RequestMethod.GET, produces = "application/json")
	public List<BandDto> getAllBands() {

		log.debug("Calling JSON service getAllBands()");

		ArrayList<BandDto> resultList = new ArrayList<BandDto>();
		
		resultList.add(new BandDto(1,"Rush",Genre.PROG_ROCK));
		resultList.add(new BandDto(2,"Pink Floyd",Genre.PROG_ROCK));
		resultList.add(new BandDto(3,"Metallica",Genre.HEAVY_METAL));
		
		return resultList;
	}

}
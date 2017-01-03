package demo.app.demoweb.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.app.demoapp.data.domain.InterestResult;
import demo.app.demoapp.services.CalculationService;
import demo.app.demoapp.services.ServiceException;
import demo.app.demoweb.mvc.data.CompoundInterestRequest;
import demo.app.demoweb.mvc.data.CompoundInterestResponse;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("calculate")
public class CalculationServiceController {

	@Autowired
	private CalculationService calculationService;

	protected final static Logger log = LoggerFactory.getLogger(CalculationServiceController.class);

	@RequestMapping(value = "/v1/computeCompoundInterest", method = RequestMethod.POST, produces = "application/json")
	public CompoundInterestResponse computeCompoundInterest(@RequestBody CompoundInterestRequest request) {

		log.debug("Calling JSON service computeCompoundInterest");

		CompoundInterestResponse response = new CompoundInterestResponse();
		if (request != null) {
			if (request.getAccounts() != null && 
					request.getStartDate() != null && 
					request.getIntervals() != null && 
					request.getFrequency() != null && 
					request.getIncludeBreakdowns() != null) {
				log.debug("Num Accounts: " + request.getAccounts().size());
				log.debug("StartDate: " + request.getStartDate());
				log.debug("Intervals: " + request.getIntervals());
				log.debug("Frequency: " + request.getFrequency());
				log.debug("IncludeBreakdowns: " + request.getIncludeBreakdowns());
				try {
					List<InterestResult> resultList = calculationService.calculateCompoundInterest(request.getAccounts(), request.getStartDate(), 
							request.getIntervals(), request.getFrequency() , request.getIncludeBreakdowns());
					if (resultList != null) {
						response.setResults(resultList);
					}
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				log.debug("Accounts list is null.");
			}
		}

		return response;
	}

}
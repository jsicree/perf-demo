package demo.app.demoweb.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.app.demoapp.data.domain.FinancialRecord;
import demo.app.demoapp.data.dto.DtoConverter;
import demo.app.demoapp.data.dto.FinancialRecordDto;
import demo.app.demoapp.services.FinancialService;
import demo.app.demoapp.services.ServiceException;
import demo.app.demoweb.ServiceVersion;
import demo.app.demoweb.mvc.data.FinancialRecordRequest;
import demo.app.demoweb.mvc.data.FinancialRecordResponse;
import demo.app.demoweb.mvc.data.Status;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("finance")
public class FinancialServiceController {

	@Autowired
	private FinancialService financialService;

	@Autowired
	private String financeActiveVersion;

	protected final static Logger log = LoggerFactory.getLogger(FinancialServiceController.class);

	protected final static String DATE_FORMAT = "MM/dd/yyyy";
	
	protected final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);

	@RequestMapping(value = "/getFinancialRecordsByDate", method = RequestMethod.POST, produces = "application/json")
	public FinancialRecordResponse getFinancialRecordsByDate(@RequestBody FinancialRecordRequest request) {
		return runGetFinancialRecordsByDate(request, ServiceVersion.valueOf(financeActiveVersion));
	}

	@RequestMapping(value = "/v1/getFinancialRecordsByDate", method = RequestMethod.POST, produces = "application/json")
	public FinancialRecordResponse getFinancialRecordsByDate_v1(@RequestBody FinancialRecordRequest request) {
		return runGetFinancialRecordsByDate(request, ServiceVersion.VERSION_1);
	}

	@RequestMapping(value = "/v2/getFinancialRecordsByDate", method = RequestMethod.POST, produces = "application/json")
	public FinancialRecordResponse getFinancialRecordsByDate_v2(@RequestBody FinancialRecordRequest request) {
		return runGetFinancialRecordsByDate(request, ServiceVersion.VERSION_2);
	}

	private FinancialRecordResponse runGetFinancialRecordsByDate(FinancialRecordRequest request, ServiceVersion version) {
		Long startTime = System.currentTimeMillis();
		log.debug("Calling JSON service getFinancialRecordsByDate (" + version + ")");

		FinancialRecordResponse response = new FinancialRecordResponse();
		response.setVersion(version.versionName());
		if (request != null) {
			if (request.getDate() != null && request.getTickerSymbols() != null
					&& !request.getTickerSymbols().isEmpty()) {
				List<FinancialRecord> recordList = new ArrayList<FinancialRecord>();
				Date date = null;

				try {
					date = DATE_FORMATTER.parse(request.getDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					response.setStatus(Status.ERROR);
					response.setMessage("An exception occurred: " + e.getLocalizedMessage());
					response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
					e.printStackTrace();
				}

				try {
					if (version == ServiceVersion.VERSION_1) {
						recordList = financialService.getFinancialRecordsForDate_v1(request.getTickerSymbols(), date);
					} else if (version == ServiceVersion.VERSION_2) {
						recordList = financialService.getFinancialRecordsForDate_v2(request.getTickerSymbols(), date);						
					}
					response.setStatus(Status.OK);
					response.setElapsedTimeMs(System.currentTimeMillis() - startTime);

				} catch (ServiceException e) {
					response.setStatus(Status.ERROR);
					response.setMessage("An exception occurred: " + e.getLocalizedMessage());
					response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
					e.printStackTrace();
				}
				
				List<FinancialRecordDto> dtoList = new ArrayList<FinancialRecordDto>();
				if (recordList != null && !recordList.isEmpty()) {
					for (FinancialRecord record : recordList) {
						dtoList.add(DtoConverter.toFinancialRecordDto(record));						
					}
				}
				response.setRecordList(dtoList);					
			} else {
				response.setStatus(Status.ERROR);
				response.setMessage("A required field is missing.");
				response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
			}
		}

		return response;
	}

}
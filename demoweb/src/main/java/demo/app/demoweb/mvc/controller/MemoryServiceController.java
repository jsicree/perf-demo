package demo.app.demoweb.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;
import demo.app.demoweb.ServiceVersion;
import demo.app.demoweb.mvc.data.DataMapRequest;
import demo.app.demoweb.mvc.data.DataMapResponse;
import demo.app.demoweb.mvc.data.Status;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("memory")
public class MemoryServiceController {

	@Autowired
	private MemoryService memoryService;

	@Autowired
	private String memoryActiveVersion;

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceController.class);

	@RequestMapping(value = "/addDataToMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse addDataToMap(@RequestBody DataMapRequest request) {
		return runAddDataToMap(request, memoryActiveVersion);
	}
	
	@RequestMapping(value = "/clearMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse clearMap() {
		return runClearMap(memoryActiveVersion);
	}

	@RequestMapping(value = "/v1/addDataToMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse addDataToBadKeyMap(@RequestBody DataMapRequest request) {
		return runAddDataToMap(request, ServiceVersion.VERSION_1.versionName());
	}
	
	@RequestMapping(value = "/v1/clearMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse clearBadKeyMap() {
		return runClearMap(ServiceVersion.VERSION_1.versionName());
	}
	
	@RequestMapping(value = "/v2/addDataToMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse addDataToGoodKeyMap(@RequestBody DataMapRequest request) {
		return runAddDataToMap(request, ServiceVersion.VERSION_2.versionName());
	}

	@RequestMapping(value = "/v2/clearMap", method = RequestMethod.POST, produces = "application/json")
	public DataMapResponse clearGoodKeyMap() {
		return runClearMap(ServiceVersion.VERSION_2.versionName());
	}
	
	private DataMapResponse runAddDataToMap(@RequestBody DataMapRequest request, String version) {

		Long startTime = System.currentTimeMillis();
		log.debug("Calling JSON service addDataToMap (" + version + ")");

		DataMapResponse response = new DataMapResponse();
		response.setVersion(version);
		if (request != null) {
			if (request.getNumIterations() != null && 
					request.getChunkSize() != null)	{
				log.debug("NumInterations: " + request.getNumIterations());
				log.debug("ChunkSize: " + request.getChunkSize());

				try {
					if (version.equalsIgnoreCase(VERSION_1)) {
						memoryService.populateBadKeyMap(request.getNumIterations(), request.getChunkSize());						
					} else if (version.equalsIgnoreCase(VERSION_2)) {
						memoryService.populateGoodKeyMap(request.getNumIterations(), request.getChunkSize());												
					}

					response.setStatus(Status.OK);
					response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					response.setStatus(Status.ERROR);
					response.setMessage("An exception occurred: " + e.getLocalizedMessage());
					response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
					e.printStackTrace();
				}
			} else {
				response.setStatus(Status.ERROR);
				response.setMessage("The input chunk size is null.");
				response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
				log.debug("The input chunk size is null.");
			}
		}
		return response;
	}
	
	private DataMapResponse runClearMap(String version) {

		Long startTime = System.currentTimeMillis();
		log.debug("Calling JSON service clearMap (" + version + ")");
		DataMapResponse response = new DataMapResponse();
		try {
			if (version.equalsIgnoreCase(VERSION_1)) {
				memoryService.clearBadKeyMap();
			} else if (version.equalsIgnoreCase(VERSION_2)) {
				memoryService.clearGoodKeyMap();				
			}
			response.setStatus(Status.OK);
			response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
		} catch (ServiceException e) {
			response.setStatus(Status.ERROR);
			response.setMessage("An exception occurred: " + e.getLocalizedMessage());
			response.setElapsedTimeMs(System.currentTimeMillis() - startTime);
			e.printStackTrace();
		}

		return response;
	}
	
}
package demo.app.demoapp.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;

public class MemoryServiceImpl implements MemoryService {

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceImpl.class);
	
	private final static Map<BadKey, byte[]> leakyMap = new HashMap<BadKey, byte[]>();
	static class BadKey {

		Integer id;

		BadKey(Integer id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

	}

	public MemoryServiceImpl() {
	}

	public void generateOutOfMemoryViaBadKey(final Integer numIterations, final Integer chunkSize) throws ServiceException {

		log.info("Calling generateOutOfMemoryViaBadKey with numIterations = " + numIterations + ", chunkSize = " + chunkSize);

		log.info("Total/Free/Max Memory: " + Runtime.getRuntime().totalMemory() + " / " + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().maxMemory());

		log.info("Map size before iterations: " + leakyMap.size());

//		while (true)
		for (int i = 0; i < numIterations; i++) {
			if (!leakyMap.containsKey(i))
				leakyMap.put(new BadKey(i), new byte[chunkSize]);				
		}
		log.info("Map size after iterations: " + leakyMap.size());
		
	}
}

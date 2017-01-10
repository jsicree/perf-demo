package demo.app.demoapp.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;

public class MemoryServiceImpl implements MemoryService {

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceImpl.class);

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
		// TODO Auto-generated constructor stub
	}

	public void generateOutOfMemoryViaBadKey(final Integer numIterations, final Integer chunkSize) throws ServiceException {

		log.info("Calling generateOutOfMemoryViaBadKey with numIterations = " + numIterations + ", chunkSize = " + chunkSize);

		log.info("Total/Free Memory: " + Runtime.getRuntime().totalMemory() + " / " + Runtime.getRuntime().freeMemory());
		
		Map<BadKey, byte[]> m = new HashMap<BadKey, byte[]>();
//		while (true)
			for (int i = 0; i < numIterations; i++)
				if (!m.containsKey(i))
					m.put(new BadKey(i), new byte[chunkSize]);
	}
}

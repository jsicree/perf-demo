package demo.app.demoapp.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;

public class MemoryServiceImpl implements MemoryService {

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceImpl.class);
	
	private final static Map<BadKey, byte[]> BAD_KEY_MAP = new HashMap<BadKey, byte[]>();
	private final static Map<GoodKey, byte[]> GOOD_KEY_MAP = new HashMap<GoodKey, byte[]>();

	
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

	static class GoodKey {

		Integer id;

		GoodKey(Integer id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GoodKey other = (GoodKey) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
	}
	
	public MemoryServiceImpl() {
	}

	public void populateBadKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException {

		log.info("Calling populateBadKeyMap with numIterations = " + numIterations + ", chunkSize = " + chunkSize);

		log.info("Total/Free/Max Memory: " + Runtime.getRuntime().totalMemory() + " / " + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().maxMemory());

		log.info("BadKeyMap size before iterations: " + BAD_KEY_MAP.size());

		for (int i = 0; i < numIterations; i++) {
			if (!BAD_KEY_MAP.containsKey(i))
				BAD_KEY_MAP.put(new BadKey(i), new byte[chunkSize]);				
		}
		log.info("BadKeyMap size after iterations: " + BAD_KEY_MAP.size());
		
	}
	
	public void populateGoodKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException {

		log.info("Calling populateGoodKeyMap with numIterations = " + numIterations + ", chunkSize = " + chunkSize);

		log.info("Total/Free/Max Memory: " + Runtime.getRuntime().totalMemory() + " / " + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().maxMemory());

		log.info("GoodKeyMap size before iterations: " + GOOD_KEY_MAP.size());

		for (int i = 0; i < numIterations; i++) {
			if (!GOOD_KEY_MAP.containsKey(i))
				GOOD_KEY_MAP.put(new GoodKey(i), new byte[chunkSize]);				
		}
		log.info("GoodKeyMap size after iterations: " + GOOD_KEY_MAP.size());
		
	}

	public void clearBadKeyMap() throws ServiceException {
		log.info("BadKeyMap size before clear: " + BAD_KEY_MAP.size());
		BAD_KEY_MAP.clear();
		log.info("BadKeyMap size after clear: " + BAD_KEY_MAP.size());
	}

	public void clearGoodKeyMap() throws ServiceException {
		log.info("GoodKeyMap size before clear: " + GOOD_KEY_MAP.size());
		GOOD_KEY_MAP.clear();
		log.info("GoodKeyMap size after clear: " + GOOD_KEY_MAP.size());
	}
	
}

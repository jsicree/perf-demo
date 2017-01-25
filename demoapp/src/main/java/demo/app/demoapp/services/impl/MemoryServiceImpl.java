package demo.app.demoapp.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.app.demoapp.services.MemoryService;
import demo.app.demoapp.services.ServiceException;

/**
 * Implementation of a simple memory service.
 * 
 * @author joseph_sicree
 *
 */
public class MemoryServiceImpl implements MemoryService {

	protected final static Logger log = LoggerFactory.getLogger(MemoryServiceImpl.class);
	
	// A map that uses an improperly implemented key class
	private final static Map<BadKey, byte[]> BAD_KEY_MAP = new HashMap<BadKey, byte[]>();

	// A map the uses a properly implemented key class
	private final static Map<GoodKey, byte[]> GOOD_KEY_MAP = new HashMap<GoodKey, byte[]>();

	/**
	 * A key class that is missing an equals() method. The superclass
	 * equals would not properly compare two instance based on 
	 * their id values, meaning that BadKey(1) != BadKey(1).
	 * 
	 * @author joseph_sicree
	 *
	 */
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

	/**
	 * A key class that implements an equals() method. The equals()
	 * will properly compare two instance based on 
	 * their id values, meaning that GoodKey(1) == GoodKey(1).
	 * 
	 * @author joseph_sicree
	 *
	 */
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
	
	/**
	 * Default ctor.
	 * 
	 */
	public MemoryServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.MemoryService#populateBadKeyMap(java.lang.Integer, java.lang.Integer)
	 */
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
	
	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.MemoryService#populateGoodKeyMap(java.lang.Integer, java.lang.Integer)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.MemoryService#clearBadKeyMap()
	 */
	public void clearBadKeyMap() throws ServiceException {
		log.info("BadKeyMap size before clear: " + BAD_KEY_MAP.size());
		BAD_KEY_MAP.clear();
		log.info("BadKeyMap size after clear: " + BAD_KEY_MAP.size());
	}

	/*
	 * (non-Javadoc)
	 * @see demo.app.demoapp.services.MemoryService#clearGoodKeyMap()
	 */
	public void clearGoodKeyMap() throws ServiceException {
		log.info("GoodKeyMap size before clear: " + GOOD_KEY_MAP.size());
		GOOD_KEY_MAP.clear();
		log.info("GoodKeyMap size after clear: " + GOOD_KEY_MAP.size());
	}
	
}

package demo.app.demoapp.services;

/**
 * The interface for a simple memory service
 * 
 * @author joseph_sicree
 *
 */
public interface MemoryService {

	/**
	 * Add blocks of data to the <code>Map</code> that uses a bad key class.
	 * 
	 * @param numIterations
	 * @param chunkSize
	 * @throws ServiceException
	 */
	public void populateBadKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException;

	/**
	 * Clears the <code>Map</code> that uses a bad key class.
	 * 
	 * @throws ServiceException
	 */
	public void clearBadKeyMap() throws ServiceException;

	/**
	 * Add blocks of data to the <code>Map</code> that uses a valid key class.
	 * 
	 * @param numIterations
	 * @param chunkSize
	 * @throws ServiceException
	 */
	public void populateGoodKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException;

	/**
	 * Clears the <code>Map</code> that uses a valid key class.
	 * 
	 * @throws ServiceException
	 */
	public void clearGoodKeyMap() throws ServiceException;

}

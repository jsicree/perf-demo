package demo.app.demoapp.services;

public interface MemoryService {

	public void populateBadKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException;
	public void clearBadKeyMap() throws ServiceException;

	public void populateGoodKeyMap(final Integer numIterations, final Integer chunkSize) throws ServiceException;
	public void clearGoodKeyMap() throws ServiceException;

}

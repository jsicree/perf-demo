package demo.app.demoapp.services;

public interface MemoryService {

	public void generateOutOfMemoryViaBadKey(final Integer numIterations, final Integer chunkSize) throws ServiceException;
	
}

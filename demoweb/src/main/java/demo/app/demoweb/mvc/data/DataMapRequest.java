package demo.app.demoweb.mvc.data;

public class DataMapRequest {
	private Integer numIterations;
	private Integer chunkSize;

	public DataMapRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataMapRequest(Integer numIterations, Integer chunkSize) {
		super();
		this.numIterations = numIterations;
		this.chunkSize = chunkSize;
	}

	public Integer getNumIterations() {
		return numIterations;
	}
	public void setNumIterations(Integer numIterations) {
		this.numIterations = numIterations;
	}
	public Integer getChunkSize() {
		return chunkSize;
	}
	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}
	@Override
	public String toString() {
		return "DataMapRequest [numIterations=" + numIterations + ", chunkSize=" + chunkSize + "]";
	}

	
	
}

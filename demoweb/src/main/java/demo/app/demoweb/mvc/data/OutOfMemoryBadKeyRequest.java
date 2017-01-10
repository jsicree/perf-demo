package demo.app.demoweb.mvc.data;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;

public class OutOfMemoryBadKeyRequest {
	private Integer numIterations;
	private Integer chunkSize;

	public OutOfMemoryBadKeyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutOfMemoryBadKeyRequest(Integer numIterations, Integer chunkSize) {
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
		return "OutOfMemoryBadKeyRequest [numIterations=" + numIterations + ", chunkSize=" + chunkSize + "]";
	}

	
	
}

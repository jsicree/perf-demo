package demo.app.demoweb.mvc.data;

import java.util.List;

import demo.app.demoapp.data.domain.InterestResult;

public class CompoundInterestResponse extends ServiceResponse {
	private List<InterestResult> results;

	public CompoundInterestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompoundInterestResponse(Status status, String message, Long elapsedTimeMs, List<InterestResult> results) {
		super(status, message, elapsedTimeMs);
		this.results = results;
	}

	public List<InterestResult> getResults() {
		return results;
	}
	public void setResults(List<InterestResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "CompoundInterestResponse [status=" + getStatus() + ", elapsedTimeMs=" + getElapsedTimeMs() + ", message=" + getMessage() + ", results=" + results + "]";
	}
	
}

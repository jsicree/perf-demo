package demo.app.demoweb.mvc.data;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;
import demo.app.demoapp.data.domain.InterestResult;

public class CompoundInterestResponse {
	private List<InterestResult> results;

	public CompoundInterestResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompoundInterestResponse(List<InterestResult> results) {
		super();
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
		return "CompoundInterestResponse [results=" + results + "]";
	}
	
	
}

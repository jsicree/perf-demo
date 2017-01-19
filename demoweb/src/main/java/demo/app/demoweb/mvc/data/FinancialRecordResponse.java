package demo.app.demoweb.mvc.data;

import java.util.List;

import demo.app.demoapp.data.dto.FinancialRecordDto;

public class FinancialRecordResponse extends ServiceResponse {

	private List<FinancialRecordDto> recordList;
	
	public FinancialRecordResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinancialRecordResponse(List<FinancialRecordDto> recordList) {
		super();
		this.recordList = recordList;
	}

	public List<FinancialRecordDto> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<FinancialRecordDto> recordList) {
		this.recordList = recordList;
	}

	@Override
	public String toString() {
		return "FinancialRecordResponse [recordList=" + recordList + ", getStatus()=" + getStatus() + ", getMessage()="
				+ getMessage() + ", getElapsedTimeMs()=" + getElapsedTimeMs() + ", getVersion()=" + getVersion() + "]";
	}
	
}

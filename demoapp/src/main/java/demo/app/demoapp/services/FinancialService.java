package demo.app.demoapp.services;

import java.util.List;

import demo.app.demoapp.data.domain.FinancialInstrument;
import demo.app.demoapp.data.domain.FinancialRecord;

public interface FinancialService {

	public List<FinancialInstrument> getAllFinancialInstruments() throws ServiceException;
	
	public List<FinancialRecord> getAllFinancialRecords() throws ServiceException;
	
//	public void computeAveragePrice(final List<String> symbolList, final Date fromDate, final Date toDate) throws ServiceException;
}

package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.FinancialInstrument;
import demo.app.demoapp.data.domain.FinancialRecord;

public interface FinancialService {

	public List<FinancialInstrument> getAllFinancialInstruments() throws ServiceException;
	
	public List<FinancialRecord> getAllFinancialRecords() throws ServiceException;
	
	public List<FinancialRecord> getFinancialRecordsForDate_v1(final List<String> symbolList, final Date date) throws ServiceException;
	public List<FinancialRecord> getFinancialRecordsForDate_v2(final List<String> symbolList, final Date date) throws ServiceException;

}

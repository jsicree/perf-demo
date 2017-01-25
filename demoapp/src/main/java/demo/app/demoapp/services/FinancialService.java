package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.FinancialInstrument;
import demo.app.demoapp.data.domain.FinancialRecord;

/**
 * The interface for a simple lookup service
 * 
 * @author joseph_sicree
 *
 */
public interface FinancialService {

	/**
	 * Fetch all <code>FinancialInstrument</code>
	 * 
	 * @return A <code>List</code> of <code>FinancialInstrument</code>
	 * 
	 * @throws ServiceException
	 */
	public List<FinancialInstrument> getAllFinancialInstruments() throws ServiceException;

	/**
	 * Fetch all <code>FinancialRecord</code>
	 * 
	 * @return A <code>List</code> of <code>FinancialRecord</code>
	 * 
	 * @throws ServiceException
	 */
	public List<FinancialRecord> getAllFinancialRecords() throws ServiceException;
	
	/**
	 * Fetches a list of <code>FinancialRecord</code> by symbols and dates. This
	 * implementation has an N+1 query issue.
	 * 
	 * @param symbolList
	 * @param date
	 * 
	 * @return A <code>List</code> of <code>FinancialRecord</code>
	 * 
	 * @throws ServiceException
	 */
	public List<FinancialRecord> getFinancialRecordsForDate_v1(final List<String> symbolList, final Date date) throws ServiceException;

	/**
	 * Fetches a list of <code>FinancialRecord</code> by symbols and dates. This
	 * implementation fixes the N+1 query issue.
	 * 
	 * @param symbolList
	 * @param date
	 * 
	 * @return A <code>List</code> of <code>FinancialRecord</code>
	 * 
	 * @throws ServiceException
	 */
	public List<FinancialRecord> getFinancialRecordsForDate_v2(final List<String> symbolList, final Date date) throws ServiceException;

}

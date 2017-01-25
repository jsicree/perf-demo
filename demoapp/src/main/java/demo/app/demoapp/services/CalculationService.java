package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import demo.app.demoapp.data.dto.AccountInfo;
import demo.app.demoapp.data.dto.Frequency;
import demo.app.demoapp.data.dto.InterestResult;

/**
 * The interface for a simple calculation service
 * 
 * @author joseph_sicree
 *
 */
public interface CalculationService {

	/**
	 * Synchronous implementation of a compound interest calculation.
	 * 
	 * @param accounts
	 * @param startDate
	 * @param intervals
	 * @param freq
	 * @param includeBreakdowns
	 * 
	 * @return A <code>List</code> of <code>InterestResult</code>
	 * 
	 * @throws ServiceException
	 */
	public List<InterestResult> calculateCompoundInterest(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException;

	/**
	 * Asynchronous implementation of a compound interest calculation.
	 * 
	 * @param accounts
	 * @param startDate
	 * @param intervals
	 * @param freq
	 * @param includeBreakdowns
	 * 
	 * @return A <code>List</code> of <code>InterestResult</code>
	 * 
	 * @throws ServiceException
	 */
	public List<InterestResult> calculateCompoundInterestAsync(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException;	
}

package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import demo.app.demoapp.data.dto.AccountInfo;
import demo.app.demoapp.data.dto.Frequency;
import demo.app.demoapp.data.dto.InterestResult;

public interface CalculationService {

	public List<InterestResult> calculateCompoundInterest(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException;

	public List<InterestResult> calculateCompoundInterestAsync(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException;	
}

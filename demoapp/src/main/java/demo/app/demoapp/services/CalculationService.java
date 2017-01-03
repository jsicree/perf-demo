package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;

import demo.app.demoapp.data.domain.AccountInfo;
import demo.app.demoapp.data.domain.Frequency;
import demo.app.demoapp.data.domain.InterestResult;

public interface CalculationService {

	public List<InterestResult> calculateCompoundInterest(final List<AccountInfo> accounts, final Date startDate,
			final Integer intervals, final Frequency freq, final Boolean includeBreakdowns) throws ServiceException;
	
}

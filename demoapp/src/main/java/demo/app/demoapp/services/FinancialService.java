package demo.app.demoapp.services;

import java.util.Date;
import java.util.List;

public interface FinancialService {

	public void computeAveragePrice(final List<String> symbolList, final Date fromDate, final Date toDate) throws ServiceException;
}

package demo.app.demoapp.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import demo.app.demoapp.services.FinancialService;
import demo.app.demoapp.services.ServiceException;

@Service
public class FinancialServiceImpl implements FinancialService {

	protected final static Logger log = LoggerFactory.getLogger(FinancialServiceImpl.class);

	public FinancialServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void computeAveragePrice(List<String> symbolList, Date fromDate, Date toDate) throws ServiceException {
		// TODO Auto-generated method stub

	}

}

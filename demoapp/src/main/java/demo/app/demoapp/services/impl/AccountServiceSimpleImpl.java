package demo.app.demoapp.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import demo.app.demoapp.data.domain.Account;
import demo.app.demoapp.data.domain.AccountStatus;
import demo.app.demoapp.data.domain.AccountType;
import demo.app.demoapp.services.AccountService;
import demo.app.demoapp.services.NotImplementedException;
import demo.app.demoapp.services.ServiceException;

@Service
public class AccountServiceSimpleImpl implements AccountService {

	protected final static Logger log = LoggerFactory.getLogger(AccountServiceSimpleImpl.class);

	private static final Account[] ACCOUNT_ARRAY = { 
			new Account(new Integer(1), "XYZ-001", AccountType.BASIC, new Date(), new Double(5300.40), new Date(), AccountStatus.ACTIVE), 	
			new Account(new Integer(2), "ABC-392", AccountType.PREMIUM, new Date(), new Double(10500.00), new Date(), AccountStatus.ACTIVE) 	
	};
	
	public AccountServiceSimpleImpl() {
		// TODO Auto-generated constructor stub
	}

	public Account getAccount(Long id) throws ServiceException {
		Account result = null;
		
		for (Account s : ACCOUNT_ARRAY) {
			if (s.getId().equals(id)) {
				result = s;
				break;
			}
		}
		return result;
	}

	public Account getAccountByIdentifier(String identifier) throws ServiceException {
		Account result = null;
		
		for (Account s : ACCOUNT_ARRAY) {
			if (s.getIdentifier().equalsIgnoreCase(identifier)) {
				result = s;
				break;
			}
		}
		return result;
	}

	public List<Account> getAllAccounts() throws ServiceException {
		List<Account> result = new ArrayList<Account>();
		for (Account s : ACCOUNT_ARRAY) {
			result.add(s);
		}		
		return result;
	}

	public Account createAccount(Account newAccount) throws ServiceException {
		throw new NotImplementedException("This method has not been implemented");
	}

	public Account deleteAccount(Long id) throws ServiceException {		
		throw new NotImplementedException("This method has not been implemented");
	}

}

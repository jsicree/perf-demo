package demo.app.demoapp.services;

import java.util.List;

import demo.app.demoapp.data.dto.Account;

public interface AccountService {

	public Account getAccount(final Long id) throws ServiceException;
	public Account getAccountByIdentifier(final String identifier) throws ServiceException;
	public List<Account> getAllAccounts() throws ServiceException;
	public Account createAccount(final Account newAccount) throws ServiceException;
	public Account deleteAccount(final Long id) throws ServiceException;
	
}

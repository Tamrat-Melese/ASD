package framework.factory.service;

import framework.factory.dao.DAOFactory;
import framework.service.AccountService;
import framework.service.AccountServiceImp;
import framework.service.AccountServiceInvoker;
import framework.service.AccountServiceObservableProxy;
import framework.service.CustomerService;
import framework.service.CustomerServiceImp;

public class ServiceFactory {
	private static volatile AccountService accountService;
	private static volatile CustomerService customerService;
	
	
	public static AccountService createAccountService() {
		if(null == accountService) {
			synchronized(ServiceFactory.class) {
				if(null == accountService) {
					
					AccountServiceImp accountServiceImp = new AccountServiceImp();
					accountServiceImp.setAccountDAO(DAOFactory.createAccountDAO());
					
					accountService = new AccountServiceInvoker(new AccountServiceObservableProxy(accountServiceImp));
				}
			}
		}
		
		return accountService;
	}
	
	public static CustomerService createCustomerService() {
		if(null == customerService) {
			synchronized(ServiceFactory.class) {
				if(null == customerService) {
					CustomerServiceImp customerServiceImp = new CustomerServiceImp();
					customerServiceImp.setCustomerDAO(DAOFactory.createCustomerDAO());
					
					customerService = customerServiceImp;
				}
			}
		}
		
		return customerService;
	}

}

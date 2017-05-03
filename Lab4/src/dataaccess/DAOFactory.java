package dataaccess;

public class DAOFactory {

	public AccountDAO createAccountDAO(Environment environment){
		if(environment == Environment.PRODUCTION){
			return new AccountDAOImpl();
		}
		else if(environment == Environment.TEST){
			return new MockAccountDAOImpl();
		}
		else {
			return null;
		}
		
	}
}

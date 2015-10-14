package factory;

import java.sql.Connection;

import factory.MySQL.MySQLAccountDAO;
import factory.MySQL.MySQLCustomerDAO;
import factory.MySQL.MySQLOrderDAO;


public class MySQLDAOFactory extends DAOFactory {
	public static final String DRIVER = "COM.cloudscape.core.RmiJdbcDriver";
	public static final String DBURL = "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

//	public static Connection createConnection() {

//	}

	public CustomerDAO getCustomerDAO() {
		return new MySQLCustomerDAO();
	}

	public AccountDAO getAccountDAO() {
		return new MySQLAccountDAO();
	}

	public OrderDAO getOrderDAO() {
		return new MySQLOrderDAO();
	}
}

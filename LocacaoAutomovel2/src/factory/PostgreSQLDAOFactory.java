package factory;

import java.sql.Connection;

import factory.PostgreSQL.PostgreSQLAccountDAO;
import factory.PostgreSQL.PostgreSQLCustomerDAO;
import factory.PostgreSQL.PostgreSQLOrderDAO;


public class PostgreSQLDAOFactory extends DAOFactory {
	public static final String DRIVER = "COM.cloudscape.core.RmiJdbcDriver";
	public static final String DBURL = "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

	//public static Connection createConnection() {
		// Use DRIVER and DBURL to create a connection
		// Recommend connection pool implementation/usage
	//}

	public CustomerDAO getCustomerDAO() {
		// CloudscapeCustomerDAO implements CustomerDAO
		return new PostgreSQLCustomerDAO();
	}

	public AccountDAO getAccountDAO() {
		// CloudscapeAccountDAO implements AccountDAO
		return new PostgreSQLAccountDAO();
	}

	public OrderDAO getOrderDAO() {
		// CloudscapeOrderDAO implements OrderDAO
		return new PostgreSQLOrderDAO();
	}
}

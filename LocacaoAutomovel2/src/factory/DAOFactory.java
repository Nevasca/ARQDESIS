package factory;

public abstract class DAOFactory {

	public static final int PostgreSQL = 1;
	public static final int MYSQL = 2;

	public abstract CustomerDAO getCustomerDAO();

	public abstract AccountDAO getAccountDAO();

	public abstract OrderDAO getOrderDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		
		switch (whichFactory) {
		
		case PostgreSQL:
			return new PostgreSQLDAOFactory();
			
		case MYSQL:
			return new MySQLDAOFactory();

		default:
			return null;
		}
	}
}
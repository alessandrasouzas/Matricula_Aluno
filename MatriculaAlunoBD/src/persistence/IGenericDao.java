package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGenericDao {
	
	Connection getConnection() throws SQLException, ClassNotFoundException;	
	void closeConnection() throws SQLException, ClassNotFoundException;	 
		
		
}

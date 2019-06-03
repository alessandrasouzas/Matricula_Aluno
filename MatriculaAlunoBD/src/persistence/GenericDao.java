package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao implements IGenericDao {
	private Connection con;
	private static GenericDao instancia;
		
	public static GenericDao getInstance() {
		if (instancia == null) { 
			instancia = new GenericDao();
		}
		return instancia;			
	}
		
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName ("net.sourceforge.jtds.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=Matricula_Aluno;", "Aluno", "123456");
		System.out.println("Conectado com sucesso!");
		
		return con;
	}

	@Override
	public void closeConnection() throws SQLException{
		if(con != null) 
			con.close();
		con = null;
		System.out.println("Desconectado com sucesso!");		
	}
	

}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;

public class AlunoDao implements IAlunoDao {
	private Connection c;

	public AlunoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void adicionar(Aluno aluno) throws SQLException, ClassNotFoundException {
		String sql = "EXEC  INSERT_ALUNO ?, ?, ?";
		// String sql = "INSERT INTO Aluno (ra, nome, e_mail) Values (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		try {			
			ps.setString(1, aluno.getRa());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getE_mail());

			ps.execute();
			ps.close();
			System.out.println("Adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

//	@Override
//	public void remover(Aluno aluno) throws SQLException {
//		String sql = "Exec Delete_Aluno ?";
//		PreparedStatement ps = c.prepareStatement(sql);
//		try {
//			ps.setString(1, aluno.getRa());
//		} catch (Exception e) {
//			System.out.println("Erro: " + e);
//		}
//		System.out.println("Removido com sucesso!");
//	}

}

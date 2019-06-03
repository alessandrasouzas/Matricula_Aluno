package persistence;

import java.sql.SQLException;

import model.Aluno;

public interface IAlunoDao {
	
	void adicionar(Aluno aluno) throws SQLException, ClassNotFoundException;

//	void remover(Aluno aluno) throws SQLException, ClassNotFoundException;

	

}

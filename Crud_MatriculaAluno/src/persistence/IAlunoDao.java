package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Aluno;

public interface IAlunoDao {

	void insere(Aluno aluno) throws SQLException, ClassNotFoundException;
	void delete(String ra) throws SQLException, ClassNotFoundException;
	void atualiza(String ra) throws SQLException, ClassNotFoundException;
	List<Aluno> consultaRa(String ra) throws SQLException, ClassNotFoundException;

}

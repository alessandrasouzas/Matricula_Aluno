package control;

import java.sql.SQLException;

import model.Aluno;
import persistence.AlunoDao;
import persistence.IAlunoDao;

public class ControlAluno {

	private IAlunoDao aDao;

	public ControlAluno() {
		try {
			aDao = new AlunoDao();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: " + e);
		}
	}

	public void adicionar(Aluno aluno) throws SQLException {
		try {
			aDao.adicionar(aluno);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e);
		}
	}

//	public void remover(Aluno aluno) throws SQLException {
//		try {
//			aDao.remover(aluno);
//		} catch (ClassNotFoundException e) {
//			System.out.println("Erro: " + e);
//		}
//	}

}

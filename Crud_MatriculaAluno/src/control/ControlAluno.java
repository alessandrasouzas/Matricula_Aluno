package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import persistence.AlunoDao;
import persistence.IAlunoDao;

public class ControlAluno {
	private List<Aluno> lstAluno = new ArrayList<>();
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
			aDao.insere(aluno);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e);
		}		
	}

	public void delete(String ra) throws SQLException {
		try {
			aDao.delete(ra);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e);
			e.printStackTrace();
		}
	}

	public void atualiza(String ra) throws SQLException {
		try {			
			aDao.atualiza(ra);
		} catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}

	public List<Aluno> consultaRa(String ra) {
		try {
			lstAluno = aDao.consultaRa(ra);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		return lstAluno;
	}
}

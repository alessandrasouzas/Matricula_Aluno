package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Aluno;

public class AlunoDao implements IAlunoDao {
	private Connection c;

	public AlunoDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void insere(Aluno aluno) throws SQLException, ClassNotFoundException {
		String sql = "EXEC INSERT_ALUNO ?, ?, ?";
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

	@Override
	public void delete(String ra) throws SQLException, ClassNotFoundException {		
		try {
			String sql = "EXEC DELETE_ALUNO ?";
			PreparedStatement ps;
			ps = c.prepareStatement(sql);
			ps.setString(1, ra);
			
			ps.execute();
			ps.close();
			System.out.println("Excluído com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}		

	}

	@Override
	public void atualiza(String ra) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE Aluno SET ra = ?, nome = ?, e_mail = ? WHERE ra = " + ra;
		PreparedStatement ps = c.prepareStatement(sql);
		Scanner scan = new Scanner(System.in);
		try {
			Aluno aluno = new Aluno();
			System.out.println("Digite o ra: ");
			aluno.setRa(scan.nextLine());			
			ps.setString(1, aluno.getRa());
			
			System.out.println("Digite o nome: ");
			aluno.setNome(scan.nextLine());			
			ps.setString(2, aluno.getNome());
			
			System.out.println("Digite o Email: ");
			aluno.setE_mail(scan.nextLine());			
			ps.setString(3, aluno.getE_mail());
						
			ps.executeUpdate();
			System.out.println("\nMatricula atualizada com sucesso!");
			
		}catch (Exception e) {
			System.out.println("Erro: "+e);
		}
	}
	
	@Override
	public List<Aluno> consultaRa(String ra) {
		List<Aluno> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Aluno WHERE ra = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, ra);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Aluno al = new Aluno();
				al.setRa(rs.getString("ra"));
				al.setNome(rs.getString("nome"));
				al.setE_mail(rs.getString("e_mail"));
				lista.add(al);
				System.out.println("\nDados do Aluno: ");
				for (Aluno l : lista)
					System.out.println("RA: " + l.getRa() + "\nNome: " + l.getNome() + "\nEmail: " + l.getE_mail());
			} else {
				System.out.println("Aluno não encontrado!");
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		return lista;
	}

}

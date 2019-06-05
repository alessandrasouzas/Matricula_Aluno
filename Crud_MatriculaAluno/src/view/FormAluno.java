/*
   Autor: Alessandra Souza @2019
*/
package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import control.ControlAluno;
import model.Aluno;

public class FormAluno {

	private static ControlAluno control = new ControlAluno();

	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
		int opc;

		System.out.println("Escolha uma opção:\n" + "1- Matricular Aluno \n" + "2- Pesquisar Aluno \n"
				+ "3- Alterar Matricula \n" + "4 -Excluir Matricula \n");
		opc = scan.nextInt();
		// Adicionar um aluno
		if (opc == 1) {
			try {
				Aluno aluno = new Aluno();

				System.out.println("Digite seu RA: \n");
				aluno.setRa(scan.next());

				System.out.println("Digite seu Nome: \n");
				aluno.setNome(scan.next());

				System.out.println("Digite seu E_mail: \n");
				aluno.setE_mail((scan.next()));

				control.adicionar(aluno);
			} catch (SQLException e) {
				System.out.println("Erro" + e);
			}			
		}
		// Pesquisar por aluno
		else if (opc == 2) {

			System.out.println("Digite o RA do aluno: ");
			String ra = scan.next();
			List<Aluno> lstAluno = control.consultaRa(ra);

		}
		// Alterar matricula de aluno
		else if (opc == 3) {
			String ra;
			System.out.println("Digite o RA do aluno: ");
			ra = scan.next();
			control.atualiza(ra);
		}

		// Excluir um aluno
		else if (opc == 4) {
			String ra;
			System.out.println("Digite o RA do aluno: \n");
			ra = (scan.next());
			control.delete(ra);
		}

		else
			System.out.println("Opção Inválida!");
	}
}

package view;

import java.sql.SQLException;
import java.util.Scanner;

import control.ControlAluno;
import model.Aluno;

public class FormAluno {

	private static ControlAluno control = new ControlAluno();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int opc;

		System.out.println("Escolha uma opção:\n" + "1- Adicionar Aluno:\n" + "2- Remover Aluno:\n");
		opc = scan.nextInt();

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

//		} else if (opc == 2) {
//			Aluno aluno = new Aluno();
//
//			System.out.println("Digite seu RA: \n");
//			aluno.setRa(scan.next());
//			try {
//				control.remover(aluno);
//			} catch (SQLException e) {
//				System.out.println("Erro: " + e);
//			}
		}
	}
}

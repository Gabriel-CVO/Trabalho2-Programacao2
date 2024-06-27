package app;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoScanner {

	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Insira o nome:");
		contato.setNome(s.nextLine());
		System.out.println("Insira o email:");
		contato.setEmail(s.nextLine());
		System.out.println("Insira o endereço:");
		contato.setEndereco(s.nextLine());
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s.close();
		
	}

}

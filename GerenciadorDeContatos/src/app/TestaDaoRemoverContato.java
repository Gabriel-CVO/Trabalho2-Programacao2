package app;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;

public class TestaDaoRemoverContato {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ContatoDao dao = new ContatoDao();

        System.out.println("Digite o ID do contato a ser removido:");
        int id = scanner.nextInt();

        dao.removerContato(id);
        System.out.println("Contato removido com sucesso!");
        
        scanner.close();
    }
}

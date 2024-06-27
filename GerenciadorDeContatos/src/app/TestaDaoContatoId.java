package app;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoContatoId {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do contato que deseja buscar:");
        int id = scanner.nextInt();

        try {
            ContatoDao contatoDao = new ContatoDao();
            Contato contato = contatoDao.buscarContatoPorId(id);

            if (contato == null) {
                System.out.println("Nenhum contato encontrado com o ID: " + id);
            } else {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("Endereco: " + contato.getEndereco());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar contato: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

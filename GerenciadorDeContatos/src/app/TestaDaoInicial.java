package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoInicial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a letra inicial dos contatos que deseja buscar:");
        String inicial = scanner.nextLine();

        try {
            ContatoDao contatoDao = new ContatoDao();
            List<Contato> contatos = contatoDao.buscarContatosPorInicial(inicial);

            if (contatos.isEmpty()) {
                System.out.println("Nenhum contato encontrado com a inicial: " + inicial);
            } else {
                System.out.println("Contatos encontrados:");
                for (Contato contato : contatos) {
                    System.out.println("Nome: " + contato.getNome());
                    System.out.println("Email: " + contato.getEmail());
                    System.out.println("Endereco: " + contato.getEndereco());
                    System.out.println("-------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar contatos: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


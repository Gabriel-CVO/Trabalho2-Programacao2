package app;

import java.sql.SQLException;
import java.util.Scanner;
import dao.ContatoDao;
import model.Contato;

public class TestaDaoAtualizarContato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContatoDao dao = null;
        try {
            dao = new ContatoDao();

            System.out.println("Digite o ID do contato a ser atualizado:");
            long id = scanner.nextLong();
            scanner.nextLine(); 

            Contato contato = dao.buscarContatoPorId(id);
            if (contato == null) {
                System.out.println("Contato nao encontrado!");
                return;
            }

            System.out.println("Contato atual:");
            System.out.println("ID: " + contato.getId()); 
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());

            System.out.println("Digite o novo nome (deixe vazio para nao alterar):");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                contato.setNome(novoNome);
            }

            System.out.println("Digite o novo email (deixe vazio para nao alterar):");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isEmpty()) {
                contato.setEmail(novoEmail);
            }

            System.out.println("Digite o novo endereço (deixe vazio para nao alterar):");
            String novoEndereco = scanner.nextLine();
            if (!novoEndereco.isEmpty()) {
                contato.setEndereco(novoEndereco);
            }

            dao.atualizarContato(contato);
            System.out.println("Contato atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar o contato: " + e.getMessage());
        } finally {
            scanner.close();
            if (dao != null) {
                try {
                    dao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao fechar a conexao: " + e.getMessage());
                }
            }
        }
    }
}








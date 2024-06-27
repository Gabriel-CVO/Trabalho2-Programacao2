package app;

import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

import java.sql.SQLException;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ContatoDao dao = new ContatoDao();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Buscar contatos por nome");
            System.out.println("4 - Buscar contato por ID");
            System.out.println("5 - Atualizar contato");
            System.out.println("6 - Remover contato");
            System.out.println("7 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o email do contato:");
                    String email = scanner.nextLine();

                    System.out.println("Digite o endereco do contato:");
                    String endereco = scanner.nextLine();

                    Contato contato = new Contato();
                    contato.setNome(nome);
                    contato.setEmail(email);
                    contato.setEndereco(endereco);

                    dao.adiciona(contato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;

                case 2:
                    List<Contato> contatos = dao.getLista();
                    for (Contato c : contatos) {
                        System.out.println(c.getNome() + " - " + c.getEmail() + " - " + c.getEndereco());
                    }
                    break;

                case 3:
                    System.out.println("Digite a letra inicial do nome:");
                    String letra = scanner.nextLine();
                    List<Contato> contatosPorNome = dao.buscarContatosPorInicial(letra);
                    for (Contato c : contatosPorNome) {
                        System.out.println(c.getNome() + " - " + c.getEmail() + " - " + c.getEndereco());
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do contato:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Contato contatoPorId = dao.buscarContatoPorId(id);
                    if (contatoPorId != null) {
                        System.out.println(contatoPorId.getId() + " - " + contatoPorId.getNome() + " - " + contatoPorId.getEmail() + " - " + contatoPorId.getEndereco());
                    } else {
                        System.out.println("Contato nao encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Digite o ID do contato a ser atualizado:");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    Contato contatoAtualizar = dao.buscarContatoPorId(idAtualizar);

                    if (contatoAtualizar != null) {
                        System.out.println("Digite o novo nome (deixe vazio para nao alterar):");
                        String novoNome = scanner.nextLine();
                        if (!novoNome.isEmpty()) {
                            contatoAtualizar.setNome(novoNome);
                        }

                        System.out.println("Digite o novo email (deixe vazio para nao alterar):");
                        String novoEmail = scanner.nextLine();
                        if (!novoEmail.isEmpty()) {
                            contatoAtualizar.setEmail(novoEmail);
                        }

                        System.out.println("Digite o novo endereço (deixe vazio para nao alterar):");
                        String novoEndereco = scanner.nextLine();
                        if (!novoEndereco.isEmpty()) {
                            contatoAtualizar.setEndereco(novoEndereco);
                        }

                        dao.atualizarContato(contatoAtualizar);
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Contato nao encontrado!");
                    }
                    break;

                case 6:
                    System.out.println("Digite o ID do contato a ser removido:");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    dao.removerContato(idRemover);
                    System.out.println("Contato removido com sucesso!");
                    break;

                case 7:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                	break;
                	
            }  
        }
        scanner.close();
    }
}


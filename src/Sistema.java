import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        String nome, conta;
        int agencia, opcao;
        boolean menu = true;
        String caminhoArquivo = "././././src/lista_clientes.txt";

        Scanner sc = new Scanner(System.in);
        ArrayList<Clientes> clientes = new ArrayList<>();
        File arq = new File(caminhoArquivo);
        arq.delete();

        while (menu) {

            System.out.println("-------Sistema Banco-------");
            System.out.println("| 1 - Cadastrar Clientes  |");
            System.out.println("| 2 - Listar Clientes     |");
            System.out.println("| 3 - Gravar Arquivo      |");
            System.out.println("| 4 - Consultar Arquivo   |");
            System.out.println("| 5 - Sair                |");
            System.out.println("---------------------------");
            System.out.print("Digite a opção: ");

            try {

                opcao = sc.nextInt();

                switch (opcao) {

                    case 1:

                        System.out.print("\nDigite o nome do cliente: ");
                        nome = sc.next();

                        System.out.print("Digite o numero da conta: ");
                        conta = sc.next();

                        System.out.print("Digite a agência: ");
                        agencia = sc.nextInt();

                        clientes.add(new Clientes(nome, conta, agencia));

                        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!\n" + clientes.get(clientes.size() - 1), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        if (clientes.size() > 0) {
                            System.out.println("\nLista de Clientes:");
                            clientes.forEach(cli -> System.out.print(cli.toString()));
                            System.out.println();
                            JOptionPane.showMessageDialog(null, "Lista de Clientes:\n" + clientes.listIterator().next(), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Nenhum Cliente Cadastrado", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 3:
                        if (clientes.size() > 0) {
                            try {
                                FileWriter arquivo = new FileWriter(caminhoArquivo);
                                PrintWriter gravarArquivo = new PrintWriter(arquivo);
                                for (Clientes cliente : clientes) {
                                    gravarArquivo.printf(cliente.toString());
                                }
                                arquivo.close();
                                JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!", "Arquivo", JOptionPane.INFORMATION_MESSAGE);

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Erro ao gravar o arquivo" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Lista de clientes vazia", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (arq.exists()) {
                            StringBuilder titulo = new StringBuilder("             ARQUIVO DE CLIENTES: \n\n");
                            try {
                                FileReader reader = new FileReader(caminhoArquivo);
                                BufferedReader lerArquivo = new BufferedReader(reader);
                                while (true) {
                                    String linha = lerArquivo.readLine();
                                    if (linha == null) break;
                                    titulo.append(linha).append("\n");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Erro ao Abrir o Arquivo" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                            JOptionPane.showMessageDialog(null, titulo.toString(), arq.getName(), JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 5:
                        menu = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        sc.nextLine();
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Caracter não permitido", "Erro", JOptionPane.ERROR_MESSAGE);
                sc.nextLine();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}
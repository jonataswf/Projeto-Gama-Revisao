import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
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

                    System.out.println("Cliente Cadastrado com sucesso!: ");
                    System.out.println(clientes.get(clientes.size() - 1));

                    break;

                case 2:
                    if (clientes.size() > 0) {
                        System.out.println("\nLista de Clientes:");
                        clientes.forEach(cli -> System.out.print(cli.toString()));
                        System.out.println();
                        break;
                    }
                    System.out.println("\nNenhum Cliente Cadastrado\n");
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
                            System.out.print("\nArquivo gravado com sucesso!\n\n");
                        } catch (Exception e) {
                            System.out.println("Erro ao gravar o arquivo" + e.getMessage());
                        }
                    } else {
                        System.out.println("\nLista de clientes vazia\n");
                    }
                    break;

                case 4:

                    if (arq.exists()) {

                        StringBuilder titulo = new StringBuilder("             LISTA DE CLIENTES: \n\n");

                        try {
                            FileReader reader = new FileReader(caminhoArquivo);
                            BufferedReader lerArquivo = new BufferedReader(reader);
                            while (true) {
                                String linha = lerArquivo.readLine();
                                if (linha == null) break;
                                titulo.append(linha).append("\n");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao Abrir o Arquivo" + e.getMessage());
                            e.printStackTrace();
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
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }
    }
}

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Sistema {

    public static void main(String[] args) {

        String nome, email, telefone, strConta, strOpcao, strAgencia, strSaldo;
        int conta, agencia, opcao;
        BigDecimal saldo;
        boolean menu = true;
        String caminhoArquivo = "././././src/arquivo_clientes.txt";

        ArrayList<Clientes> clientes = new ArrayList<>();
        File arq = new File(caminhoArquivo);
        arq.delete();

        while (menu) {

            try {
                strOpcao = JOptionPane.showInputDialog(null, """
                        Sistema Banco
                        1 - Cadastrar Clientes
                        2 - Listar Clientes
                        3 - Gravar Arquivo
                        4 - Consultar Arquivo
                        5 - Sair
                        """, "Cadastro",JOptionPane.QUESTION_MESSAGE);

                opcao = Integer.parseInt(strOpcao);

                switch (opcao) {

                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                        if (nome.isBlank()){
                            JOptionPane.showMessageDialog(null, "Nome inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        strConta = JOptionPane.showInputDialog("Digite o numero da conta: ");
                        conta = Integer.parseInt(strConta);

                        strAgencia = JOptionPane.showInputDialog("Digite o numero da agência: ");
                        agencia = Integer.parseInt(strAgencia);

                        email = JOptionPane.showInputDialog("Digite o email");
                        if (email.isBlank()){
                            JOptionPane.showMessageDialog(null, "Email inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        telefone = JOptionPane.showInputDialog("Digite o telefone:");
                        if (telefone.isBlank()){
                            JOptionPane.showMessageDialog(null, "Telefone inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }

                        strSaldo = JOptionPane.showInputDialog("Digite o saldo: ");
                        saldo = new BigDecimal(strSaldo);

                        clientes.add(new Clientes(nome, conta, agencia, email, telefone, saldo));

                        JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!\n" + clientes.get(clientes.size() - 1), "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        if (clientes.size() > 0) {
                            StringBuilder titulo = new StringBuilder("            LISTA DE CLIENTES \n");
                            clientes.forEach(cli -> titulo.append(cli.toString()));
                            JOptionPane.showMessageDialog(null, titulo.toString(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
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
                                JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!\n" + arq.getPath(), "Arquivo", JOptionPane.INFORMATION_MESSAGE);

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Erro ao gravar o arquivo" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Lista de clientes vazia", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (arq.exists()) {
                            StringBuilder titulo = new StringBuilder("           ARQUIVO DE CLIENTES:\n");
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
                            JOptionPane.showMessageDialog(null, "Arquivo não encontrado\ngrave primeiro (opcao3)", "Erro", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 5:
                        menu = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção Inválida!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas numero", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
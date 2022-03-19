public class Clientes {

    private String nome, conta;
    private int agencia;

    public Clientes(String nome, String conta, int agencia) {
        this.nome = nome;
        this.conta = conta;
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " Conta: " + conta +
                " Agencia:" + agencia + "\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
}

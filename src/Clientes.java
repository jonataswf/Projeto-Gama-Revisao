public class Clientes {

    private final String nome;
    private final int conta;
    private final int agencia;

    public Clientes(String nome, int conta, int agencia) {
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











}

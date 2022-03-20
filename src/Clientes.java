import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Clientes {

    private final String nome;
    private final Integer conta;
    private final Integer agencia;
    private final String email;
    private final String telefone;
    private final BigDecimal saldo;

    public Clientes(String nome, int conta, int agencia, String email, String telefone, BigDecimal saldo) {
        this.nome = nome;
        this.conta = conta;
        this.agencia = agencia;
        this.email = email;
        this.telefone = telefone;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("#.##");
        return "Nome: " + nome +
                " Conta: " + conta +
                " Agencia:" + agencia +
                " Email: " + email +
                " Telefone: " + telefone +
                " Saldo: R$ " + dc.format(saldo) + "\n";
    }
}
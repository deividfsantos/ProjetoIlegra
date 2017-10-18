package Models;

public class Lancamento {

    private double valor;
    private String descricao;
    private char tipo;

    public Lancamento(double valor, String descricao, char tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}

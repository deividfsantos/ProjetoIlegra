package Models;

public class Lancamento {

    private double valor;
    private String descricao;
    private String tipo;
    private int parcelas;

    public Lancamento(double valor, String descricao, String tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
        defineParcelas();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void defineParcelas(){
        switch (tipo){
            case "a":
                break;
        }
    }
}

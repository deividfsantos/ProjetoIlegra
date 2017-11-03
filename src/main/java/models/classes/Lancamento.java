package models.classes;

import java.util.Date;

public class Lancamento {

    private double valor;
    private String descricao;
    private String tipo;
    private Date data;
    private Usuario responsavel;
    private int parcelas;
    private String tipoParcelas;

    public Lancamento(double valor, String descricao, String tipo, Date data, Usuario responsavel, int parcelas, String tipoParcelas) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.responsavel = responsavel;
        this.tipo = tipo;
        this.parcelas = parcelas;
        this.tipoParcelas = tipoParcelas;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getTipoParcelas() {
        return tipoParcelas;
    }

    public void setTipoParcelas(String tipoParcelas) {
        this.tipoParcelas = tipoParcelas;
    }

    @Override
    public String toString() {
            return  "Descricao: " + descricao +
                    "\tValor: " + valor +
                    "\tParcelas: " + parcelas +
                    "\tTipo: "+ tipo +
                    "\t\tData: " + getData()+
                    "\t\tTipo das parcelas: "+ tipoParcelas;
    }
}

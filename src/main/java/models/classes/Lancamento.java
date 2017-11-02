package models.classes;

import models.services.DataService;

import java.text.DecimalFormat;
import java.text.ParseException;
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

    public String converteTipo(){
        if(tipo.equalsIgnoreCase("r")){
            return "Renda";
        }else{
            return "Despesa";
        }
    }

    public String converteTipoParcelas(){
        if(tipoParcelas.equalsIgnoreCase("f")){
            return "Fixo";
        }else if(tipoParcelas.equalsIgnoreCase("a")){
            return "A vista";
        }else{
            return "Parcelado";
        }
    }

    public String ajustaPrint(String valor, int tamanho){
        while(valor.length()<tamanho){
            valor= valor+" ";
        }
        return valor;
    }

    public String ajustaDouble(){
        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(valor);
        return ajustaPrint(dx, 10);
    }

    @Override
    public String toString() {
            return  "Descricao: " + ajustaPrint(descricao, 20) +
                    "\tValor: " + ajustaDouble() +
                    "\tParcelas: " + ajustaPrint(String.valueOf(parcelas), 5) +
                    "\tTipo: "+ converteTipo() +
                    "\t\tData: " + DataService.regulaData(data) +
                    "\t\tTipo das parcelas: "+converteTipoParcelas();
    }
}

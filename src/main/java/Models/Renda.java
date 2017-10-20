package Models;


import DAO.UsuarioDAO;
import Factory.ConnectionFactory;

import java.sql.Connection;
import java.util.Date;

public class Renda {

    private double valor;
    private String descricao;
    private String tipo;
    private Date data;
    private Usuario responsavel;
    private int parcelas;


    public Renda(double valor, String descricao, String tipo, Date data, Usuario responsavel, int parcelas) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.responsavel = responsavel;
        this.tipo = tipo;
        this.parcelas = parcelas;
    }

    public Renda(double valor, String descricao, String tipo, Date data, Usuario responsavel) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.responsavel = responsavel;
        this.tipo = tipo;
        this.parcelas = 12;
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


}

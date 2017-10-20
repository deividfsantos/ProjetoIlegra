package DAO;

import Models.Renda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RendaDAO {

    private Connection con;

    public RendaDAO(Connection con) {
        this.con = con;
    }

    public void insertRenda(Renda renda){
        String sql= "insert into lancamento (descricao, tipo, valor, cod_responsavel, data_parcela) values (?,?,?,?,?)";

        try{

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,renda.getDescricao());
            preparador.setString(2, renda.getTipo());
            preparador.setDouble(3,renda.getValor());
            preparador.setInt(4,renda.getResponsavel().getCodUser());
            preparador.setDate(5, converte(renda.getData()));
            preparador.execute();
            preparador.close();

        }catch (SQLException e){
            System.out.println("Erro: "+e.getMessage());
        }

    }

    private Date converte(java.util.Date data) {
        return new Date(data.getTime());
    }



}
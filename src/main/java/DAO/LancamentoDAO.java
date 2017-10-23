package DAO;

import Models.Lancamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class LancamentoDAO {

    private Connection con;

    public LancamentoDAO(Connection con) {
        this.con = con;
    }

    public void inserirLancamento(Lancamento lancamento){


        String sql= "insert into lancamento (descricao, tipo, valor, cod_responsavel, data_parcela, tipo_parcela) values (?,?,?,?,?,?)";

        for (int i = 0; i < 1/*lancamento.getParcelas()*/; i++) {


            try{
                Calendar cal = Calendar.getInstance();
                cal.setTime(lancamento.getData());


                PreparedStatement preparador = con.prepareStatement(sql);
                preparador.setString(1,lancamento.getDescricao());
                preparador.setString(2, lancamento.getTipo());
                preparador.setDouble(3,lancamento.getValor());
                preparador.setInt(4,lancamento.getResponsavel().getCodUser());
                preparador.setDate(5, converte(cal.getTime()));
                preparador.setString(6, lancamento.getTipoParcelas());




                preparador.execute();
                preparador.close();

            }catch (SQLException e){
                System.out.println("Erro: "+e.getMessage());
            }


        }

    }

/*    private Date adicionaUmMes(){

    }
  */
    private Date converte(java.util.Date data) {
        return new Date(data.getTime());
    }



}

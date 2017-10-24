package DAO;

import Models.Lancamento;
import Models.Usuario;

import java.sql.*;
import java.util.Calendar;

public class LancamentoDAO {

    private Connection con;

    public LancamentoDAO(Connection con) {
        this.con = con;
    }


    public void inserirLancamento(Lancamento lancamento){
        if (lancamento.getTipoParcelas().equalsIgnoreCase("f")) {
            for (int i = 0; i < 12; i++) {
                inserirUmLancamento(lancamento, i);
            }
        }else if(lancamento.getTipoParcelas().equalsIgnoreCase("a")){

            inserirUmLancamento(lancamento, 0);

        }else if(lancamento.getTipoParcelas().equalsIgnoreCase("p")){

            lancamento.setValor(lancamento.getValor()/lancamento.getParcelas());

            String var =  lancamento.getDescricao();

            for (int i = 0; i < lancamento.getParcelas(); i++) {
                lancamento.setDescricao(var+" ("+(i+1)+")");
                inserirUmLancamento(lancamento, i);
            }

        }

    }

    private void inserirUmLancamento(Lancamento lancamento, int i){

        String sql= "insert into lancamento (descricao, tipo, valor, cod_responsavel, data_parcela, tipo_parcela) values (?,?,?,?,?,?)";

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(lancamento.getData());
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+i);

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, lancamento.getDescricao());
            preparador.setString(2, lancamento.getTipo());
            preparador.setDouble(3, lancamento.getValor());
            preparador.setInt(4, lancamento.getResponsavel().getCodUser());
            preparador.setDate(5, converte(cal.getTime()));
            preparador.setString(6, lancamento.getTipoParcelas());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void visualizaRendas(int mes, int ano) throws SQLException {


        String sql= "SELECT lancamento.* FROM projeto_financeiro.lancamento where data_parcela='?-?-01' and data_parcela>'?-?-01'";

        PreparedStatement preparador = con.prepareStatement(sql);
        preparador.setInt(1,ano);
        preparador.setInt(2,mes);

        ResultSet resultado = preparador.executeQuery();

        while (resultado.next()){

            String descricao = resultado.getString("descricao");
            String tipo = resultado.getString("tipo");
            double valor = resultado.getDouble("valor");
            int cod_responsavel = resultado.getInt("cod_responsavel");
            java.util.Date date = resultado.getDate("data_parcela");
            String tipoParcela=resultado.getString("tipo_parcela");

            UsuarioDAO user = new UsuarioDAO(con);
            //user.retornaUsuario(cod_responsavel);

            Lancamento lancamento = new Lancamento(valor, descricao, tipo, date, );


        }


    }

    private Date converte(java.util.Date data) {
        return new Date(data.getTime());
    }



}

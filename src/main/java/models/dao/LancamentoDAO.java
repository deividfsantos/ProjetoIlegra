package models.dao;

import models.classes.Lancamento;
import models.classes.Usuario;
import models.services.DataService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class LancamentoDAO {

    private Connection con;

    public LancamentoDAO(Connection con) {
        this.con = con;
    }


    public void inserirUmLancamento(Lancamento lancamento, int i){

        String sql= "insert into lancamento (descricao, tipo, valor, cod_responsavel, data_parcela, tipo_parcela) values (?,?,?,?,?,?)";

        UsuarioDAO user = new UsuarioDAO(con);
        Usuario responsavel = user.retornaUsuario(lancamento.getResponsavel().getNomeUsuario());

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(lancamento.getData());
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+i);

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, lancamento.getDescricao());
            preparador.setString(2, lancamento.getTipo());
            preparador.setDouble(3, lancamento.getValor());
            preparador.setInt(4, responsavel.getCodigoUsuario());
            preparador.setDate(5, DataService.converte(cal.getTime()));
            preparador.setString(6, lancamento.getTipoParcelas());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }


    public ArrayList<Lancamento> visualizaValores(Usuario user, String tipoVariavel) throws SQLException {

        String sql= "SELECT lancamento.* FROM projeto_financeiro.lancamento where tipo='"+tipoVariavel+"' AND cod_responsavel = '"+user.getCodigoUsuario()+"'";

        PreparedStatement preparador = con.prepareStatement(sql);
        ResultSet resultado = preparador.executeQuery();

        ArrayList<Lancamento> lancamentos = new ArrayList<>();

        while (resultado.next()){

            String descricao = resultado.getString("descricao");
            String tipo = resultado.getString("tipo");
            double valor = resultado.getDouble("valor");
            java.util.Date date = resultado.getDate("data_parcela");
            String tipoParcela=resultado.getString("tipo_parcela");

            int parcelas = retornaQtdParcelas(descricao);

            Lancamento lancamento = new Lancamento(valor, descricao, tipo, date, user ,parcelas, tipoParcela);

            lancamentos.add(lancamento);

        }
        return lancamentos;
    }


    public ArrayList<Lancamento> visualizaValores(int mes, int ano, Usuario user, String tipoVariavel, String tipoParcelas) throws SQLException {

        String sql= "SELECT lancamento.* FROM projeto_financeiro.lancamento where data_parcela like'"+ano+"-"+mes+"-%' AND tipo='"+tipoVariavel+"' AND tipo_parcela='"+tipoParcelas+"'" +
                "AND cod_responsavel ="+user.getCodigoUsuario();

        PreparedStatement preparador = con.prepareStatement(sql);
        ResultSet resultado = preparador.executeQuery();

        ArrayList<Lancamento> lancamentos = new ArrayList<>();

        while (resultado.next()){

            String descricao = resultado.getString("descricao");
            String tipo = resultado.getString("tipo");
            double valor = resultado.getDouble("valor");
            java.util.Date date = resultado.getDate("data_parcela");

            java.sql.Date date2 = resultado.getDate("data_parcela");

            String tipoParcela=resultado.getString("tipo_parcela");
            int parcelas = retornaQtdParcelas(descricao);

            Lancamento lancamento = new Lancamento(valor, descricao, tipo, date, user ,parcelas, tipoParcela);

            lancamentos.add(lancamento);

        }
        return lancamentos;
    }

    public int retornaQtdParcelas(String descricao) throws SQLException {

        String[] valor =descricao.split(" ");

        String sql= "SELECT count(*) AS total_parcelas FROM projeto_financeiro.lancamento where descricao like '"+valor[0]+"%'";

        PreparedStatement preparador = con.prepareStatement(sql);

        ResultSet resultado = preparador.executeQuery();


        int retorno = 0;

        while (resultado.next()) {
            retorno = resultado.getInt(1);
        }
        return retorno;
    }

}

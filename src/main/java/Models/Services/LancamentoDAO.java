package Models.Services;

import Models.Classes.Lancamento;
import Models.Classes.Usuario;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class LancamentoDAO {

    private Connection con;

    public LancamentoDAO(Connection con) {
        this.con = con;
    }


    public void inserirLancamento(double valor, String descricao, String tipo, int mes, int ano, Usuario responsavel) throws ParseException {

        java.util.Date date = DataService.regulaData(mes, ano);

        Lancamento lancamento = new Lancamento(valor, descricao, tipo, date, responsavel);

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

    public void inserirLancamento(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {

        java.util.Date date = DataService.regulaData(mes, ano);

        Lancamento lancamento = new Lancamento(valor, descricao, tipoLancamento, date, user, parcelas, tipoParcelas);

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

        UsuarioDAO user = new UsuarioDAO(con);
        Usuario responsavel = user.retornaUsuario(lancamento.getResponsavel().getUserName());

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(lancamento.getData());
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+i);

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, lancamento.getDescricao());
            preparador.setString(2, lancamento.getTipo());
            preparador.setDouble(3, lancamento.getValor());
            preparador.setInt(4, responsavel.getCodUser());
            preparador.setDate(5, converte(cal.getTime()));
            preparador.setString(6, lancamento.getTipoParcelas());
            preparador.execute();
            preparador.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public ArrayList<Lancamento> visualizaValores(int mes, int ano, Usuario user, String tipoVariavel, String tipoParcelas) throws SQLException {

        String sql= "SELECT lancamento.* FROM projeto_financeiro.lancamento where data_parcela='"+ano+"-"+mes+"-01' AND tipo='"+tipoVariavel+"'" +
                "AND tipo_parcela='"+tipoParcelas+"'";

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

    public int retornaQtdParcelas(String descricao) throws SQLException {

        String[] valor =descricao.split(" ");

        String sql= "SELECT lancamento.* FROM projeto_financeiro.lancamento where descricao like '"+valor[0]+"%'";

        PreparedStatement preparador = con.prepareStatement(sql);
        ResultSet resultado = preparador.executeQuery();
        int i = 0;
        while(resultado.next()){
            i++;
        }
        return i;
    }

    public void visualizarMes(int mes, int ano, Usuario user) throws SQLException {
        System.out.println("\nRendas");
        visualizaValores(mes, ano,user,"r","a");
        visualizaValores(mes, ano,user,"r","p");
        visualizaValores(mes, ano,user,"r","f");

        System.out.println("\nDespesas");
        visualizaValores(mes, ano,user,"d","a");
        visualizaValores(mes, ano,user,"d","p");
        visualizaValores(mes, ano,user,"d","f");
    }

    private Date converte(java.util.Date data) {
        return new Date(data.getTime());
    }

}

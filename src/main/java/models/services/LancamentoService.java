package models.services;

import models.dao.LancamentoDAO;
import models.classes.Lancamento;
import models.classes.Usuario;
import models.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class LancamentoService {

    Connection con = ConnectionFactory.getConnection();
    LancamentoDAO lancamentoDAO = new LancamentoDAO(con);

    public void inserirLancamento(double valor, String descricao, String tipo, int mes, int ano, Usuario responsavel) throws ParseException {
        java.util.Date date = DataService.regulaData(mes, ano);
        Lancamento lancamento = new Lancamento(valor, descricao, tipo, date, responsavel);
        inserirLancamentos(lancamento);
    }

    public void inserirLancamento(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {
        java.util.Date date = DataService.regulaData(mes, ano);
        Lancamento lancamento = new Lancamento(valor, descricao, tipoLancamento, date, user, parcelas, tipoParcelas);
        inserirLancamentos(lancamento);
    }

    private void inserirLancamentos(Lancamento lancamento) {

        if (lancamento.getTipoParcelas().equalsIgnoreCase("f")) {
            for (int i = 0; i < 12; i++) {
                lancamentoDAO.inserirUmLancamento(lancamento, i);
            }
        }else if(lancamento.getTipoParcelas().equalsIgnoreCase("a")){

            lancamentoDAO.inserirUmLancamento(lancamento, 0);

        }else if(lancamento.getTipoParcelas().equalsIgnoreCase("p")){

            lancamento.setValor(lancamento.getValor()/lancamento.getParcelas());

            String var =  lancamento.getDescricao();

            for (int i = 0; i < lancamento.getParcelas(); i++) {
                lancamento.setDescricao(var+" ("+(i+1)+")");
                lancamentoDAO.inserirUmLancamento(lancamento, i);
            }
        }
    }


    public ArrayList<Lancamento> retornaRendasMes(Usuario user, int mes, int ano) throws SQLException {
        ArrayList<Lancamento> lancamentoFinal = new ArrayList<>();

        ArrayList<Lancamento> rendaAVista= lancamentoDAO.visualizaValores(mes, ano,user,"r","a");
        ArrayList<Lancamento> rendaParcelada= lancamentoDAO.visualizaValores(mes, ano,user,"r","p");
        ArrayList<Lancamento> rendaFixa = lancamentoDAO.visualizaValores(mes, ano,user,"r","f");

        for (Lancamento lancamento: rendaAVista) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: rendaParcelada) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: rendaFixa) {
            lancamentoFinal.add(lancamento);
        }

        return lancamentoFinal;
    }

    public ArrayList<Lancamento> retornaDespesasMes(Usuario user, int mes, int ano) throws SQLException {

        ArrayList<Lancamento> lancamentoFinal = new ArrayList<>();

        ArrayList<Lancamento> despesaAVista = lancamentoDAO.visualizaValores(mes, ano,user,"d","a");
        ArrayList<Lancamento> despesaParcelada = lancamentoDAO.visualizaValores(mes, ano,user,"d","p");
        ArrayList<Lancamento> despesaFixa = lancamentoDAO.visualizaValores(mes, ano,user,"d","f");

        for (Lancamento lancamento: despesaAVista) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: despesaParcelada) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: despesaFixa) {
            lancamentoFinal.add(lancamento);
        }

        return lancamentoFinal;
    }

    public int calculaTotal(ArrayList<Lancamento> lancamentos){

        int total = 0;

        for (int i = 0; i < lancamentos.size(); i++) {
            total += lancamentos.get(i).getValor();
        }

        return total;
    }

    public int calculaRestante(int renda, int despesa){
        return renda-despesa;
    }

}

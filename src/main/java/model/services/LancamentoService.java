package model.services;

import model.dao.LancamentoDAO;
import model.classes.Lancamento;
import model.classes.Usuario;
import adjustments.DataAdjustment;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class LancamentoService {

    private LancamentoDAO lancamentoDAO;

    public LancamentoService (LancamentoDAO lancamentoDAO){
        this.lancamentoDAO = lancamentoDAO;
    }

    public void inserirLancamento(Lancamento lancamento) throws ParseException, SQLException {

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

    public ArrayList buscaLancamentosEDespesas(Usuario user, String tipoLancamento, String tipoVariavel) throws SQLException {
        return lancamentoDAO.visualizaValores(user, tipoLancamento, tipoVariavel);
    }

    public ArrayList<Lancamento> retornaMes(Usuario user, int mes, int ano, String tipoVariavel) throws SQLException, ParseException {

        ArrayList<Lancamento> lancamentoFinal = new ArrayList<>();

        Date dataUtil = DataAdjustment.regulaData(mes, ano);
        java.sql.Date dataSQL = DataAdjustment.converte(dataUtil);

        ArrayList<Lancamento> valorAvista= lancamentoDAO.visualizaValores(dataSQL,user,tipoVariavel,"a");
        ArrayList<Lancamento> valorParcelado= lancamentoDAO.visualizaValores(dataSQL, user,tipoVariavel,"p");
        ArrayList<Lancamento> valorFixo = lancamentoDAO.visualizaValores(dataSQL,user,tipoVariavel,"f");

        for (Lancamento lancamento: valorAvista) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: valorParcelado) {
            lancamentoFinal.add(lancamento);
        }

        for (Lancamento lancamento: valorFixo) {
            lancamentoFinal.add(lancamento);
        }

        return lancamentoFinal;
    }

    public double calculaTotal(ArrayList<Lancamento> lancamentos){

        double total = 0;

        for (int i = 0; i < lancamentos.size(); i++) {
            total += lancamentos.get(i).getValor();
        }

        return total;
    }

    public double calculaRestante(double renda, double despesa){
        return renda-despesa;
    }

}

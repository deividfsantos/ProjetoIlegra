package controller;

import model.classes.Lancamento;
import model.classes.Usuario;
import model.factory.ConnectionFactory;
import model.dao.LancamentoDAO;
import model.services.LancamentoService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class LancamentoController {

    private LancamentoDAO lancamentoDAO;
    private LancamentoService lancamentoService;

    public LancamentoController(){
        this.lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
        this.lancamentoService = new LancamentoService(lancamentoDAO);
    }

    public void cadastraValor(Lancamento lancamento) throws ParseException, SQLException {
        lancamentoService.inserirLancamento(lancamento);
    }

    public ArrayList buscaRendasEDespesas(Usuario user, String tipoLancamento, String tipoVariavel) throws SQLException {
        return lancamentoService.buscaLancamentosEDespesas(user, tipoLancamento, tipoVariavel);
    }

    public ArrayList buscaLancamentoMes(Usuario user, int mes, int ano, int opcao) throws SQLException, ParseException {
        if(opcao==1){
            return lancamentoService.retornaMes(user, mes, ano, "r");
        }else{
            return lancamentoService.retornaMes(user, mes, ano, "d");
        }
    }

    public double retornaTotal(ArrayList lancamentos){
        return lancamentoService.calculaTotal(lancamentos);
    }

    public double calculaRestante(double renda, double despesa){
        return lancamentoService.calculaRestante(renda, despesa);
    }

}

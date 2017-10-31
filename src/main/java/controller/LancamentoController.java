package controller;

import models.classes.Lancamento;
import models.classes.Usuario;
import models.factory.ConnectionFactory;
import models.dao.LancamentoDAO;
import models.services.DataService;
import models.services.LancamentoService;
import view.LancamentoView;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class LancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
    LancamentoService lancamentoService = new LancamentoService();

    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, Usuario user, String tipoVar) throws ParseException {
        LancamentoView lancamentoView = new LancamentoView();
        Date data = DataService.regulaData(mes, ano);
        Lancamento lancamento =  new Lancamento(valor, descricao, tipoLancamento, data, user, 12, "f");

        if(tipoVar.equalsIgnoreCase("f")){

            lancamentoService.inserirLancamento(lancamento);

        }else{
            lancamentoView.lancaVariavel(valor, descricao, tipoLancamento, mes, ano, user);
        }

    }

    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {
        Date data = DataService.regulaData(mes, ano);
        Lancamento lancamento =  new Lancamento(valor, descricao, tipoLancamento, data, user, parcelas, tipoParcelas);
        lancamentoService.inserirLancamento(lancamento);
    }

    public ArrayList<Lancamento> buscaRendasEDespesas(Usuario user, String tipoLancamento) throws SQLException {

        return lancamentoDAO.visualizaValores(user, tipoLancamento);
    }


    public ArrayList<Lancamento> buscaLancamentoMes(Usuario user, int mes, int ano, int opcao) throws SQLException, ParseException {

        if(opcao==1){
            return lancamentoService.retornaMes(user, mes, ano, "r");
        }else{
            return lancamentoService.retornaMes(user, mes, ano, "d");
        }

    }

    public double retornaTotal(ArrayList<Lancamento> lancamentos){
        return lancamentoService.calculaTotal(lancamentos);
    }

    public double calculaRestante(double renda, double despesa){
        return lancamentoService.calculaRestante(renda, despesa);
    }

}

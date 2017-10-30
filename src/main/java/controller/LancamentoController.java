package controller;

import models.classes.Lancamento;
import models.classes.Usuario;
import models.factory.ConnectionFactory;
import models.dao.LancamentoDAO;
import models.services.LancamentoService;
import view.LancamentoView;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class LancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
    LancamentoService lancamentoService = new LancamentoService();


    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, Usuario user, String tipoVar) throws ParseException {

        LancamentoView lancamentoView = new LancamentoView();

        if(tipoVar.equalsIgnoreCase("f")){
            lancamentoService.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, user);
        }else{
            lancamentoView.lancaVariavel(valor, descricao, tipoLancamento, mes, ano, user);
        }

    }

    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {
        lancamentoService.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, parcelas, tipoParcelas, user);
    }

    public ArrayList<Lancamento> buscaRendasEDespesas(Usuario user, String tipoLancamento) throws SQLException {

        return lancamentoDAO.visualizaValores(user, tipoLancamento);
    }


    public ArrayList<Lancamento> buscaLancamentoMes(Usuario user, int mes, int ano, int opcao) throws SQLException {

        if(opcao==1){
            return lancamentoService.retornaRendasMes(user, mes, ano);
        }else{
            return lancamentoService.retornaDespesasMes(user, mes, ano);
        }

    }

    public int retornaTotal(ArrayList<Lancamento> lancamentos){
        return lancamentoService.calculaTotal(lancamentos);
    }

    public int calculaRestante(int renda, int despesa){
        return lancamentoService.calculaRestante(renda, despesa);
    }

}

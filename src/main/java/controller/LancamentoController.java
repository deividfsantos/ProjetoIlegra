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
import java.util.Date;

public class LancamentoController {

    private LancamentoDAO lancamentoDAO;
    private LancamentoService lancamentoService;
    private LancamentoView lancamentoView;

    public LancamentoController(LancamentoView lancamentoView){
        this.lancamentoView = lancamentoView;
        this.lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
        this.lancamentoService = new LancamentoService(lancamentoDAO);
    }

    public void cadastraValor(double valor, String descricao, String tipoLancamento, Date data, Usuario user, String tipoVar) throws ParseException, SQLException {

        if(tipoVar.equalsIgnoreCase("f")){
            Lancamento lancamento =  new Lancamento(valor, descricao, tipoLancamento, data, user, 12, "f");
            lancamentoService.inserirLancamento(lancamento);

        }else{
            lancamentoView.menuLancaVariavel(valor, descricao, tipoLancamento, data, user);
        }

    }

    public void cadastraValor(double valor, String descricao, String tipoLancamento, Date date, int parcelas, String tipoParcelas, Usuario user) throws ParseException, SQLException {

        Lancamento lancamento =  new Lancamento(valor, descricao, tipoLancamento, date, user, parcelas, tipoParcelas);
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

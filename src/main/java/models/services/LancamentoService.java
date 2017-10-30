package models.services;

import models.dao.LancamentoDAO;
import models.classes.Lancamento;
import models.classes.Usuario;
import models.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class LancamentoService {

    Connection con = ConnectionFactory.getConnection();
    LancamentoDAO lancamentoDAO = new LancamentoDAO(con);


    public void inserirLancamento(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {
        Date date = DataService.regulaData(mes, ano);

        Lancamento lancamento = new Lancamento(valor, descricao, tipoLancamento, date, user, parcelas, tipoParcelas);

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

    public ArrayList<Lancamento> retornaMes(Usuario user, int mes, int ano, String tipoVariavel) throws SQLException, ParseException {

        ArrayList<Lancamento> lancamentoFinal = new ArrayList<>();

        Date dataUtil = DataService.regulaData(mes, ano);
        java.sql.Date dataSQL = DataService.converte(dataUtil);

        ArrayList<Lancamento> rendaAVista= lancamentoDAO.visualizaValores(dataSQL,user,tipoVariavel,"a");
        ArrayList<Lancamento> rendaParcelada= lancamentoDAO.visualizaValores(dataSQL, user,tipoVariavel,"p");
        ArrayList<Lancamento> rendaFixa = lancamentoDAO.visualizaValores(dataSQL,user,tipoVariavel,"f");

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

package Controller;

import Models.Classes.Usuario;
import Models.Factory.ConnectionFactory;
import Models.Services.LancamentoDAO;

import java.text.ParseException;

public class LancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());

    public void cadastraFixo(double valor, String descricao, String tipoLancamento, int mes, int ano, String tipo, Usuario user) throws ParseException {

        lancamentoDAO.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, user);

    }

    public void cadastraVariavel(double valor,String desc,String tipoLancamento ,int mes,int ano, Usuario user, int parcelas, String tipoParcelas) throws ParseException {

        lancamentoDAO.inserirLancamento(valor, desc, tipoLancamento, mes, ano, parcelas, tipoParcelas, user);
    }



}

package Controller;

import Models.Classes.Usuario;
import Models.Factory.ConnectionFactory;
import Models.Services.LancamentoDAO;

import java.text.ParseException;

public class LancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());

    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, String tipo, Usuario user) throws ParseException {

        lancamentoDAO.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, user);

        lancamentoDAO.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, parcelas, tipoParcelas, user);
    }



}

package Controller;

import Models.Classes.Usuario;
import Models.Factory.ConnectionFactory;
import Models.Services.LancamentoDAO;
import View.LancamentoView;

import java.text.ParseException;

public class LancamentoController {

    LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());

    public void cadastraValor(double valor, String descricao, String tipoLancamento, int mes, int ano, int parcelas, String tipoParcelas, Usuario user) throws ParseException {

        if(tipoParcelas.equalsIgnoreCase("f")){
            lancamentoDAO.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, user);
        }else {
            lancamentoDAO.inserirLancamento(valor, descricao, tipoLancamento, mes, ano, parcelas, tipoParcelas, user);
        }
    }



}

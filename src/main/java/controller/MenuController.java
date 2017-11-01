package controller;

import models.classes.Usuario;
import view.LancamentoView;
import view.UsuarioView;

import java.sql.SQLException;
import java.text.ParseException;

public class MenuController {

    UsuarioView usuarioView = new UsuarioView();
    LancamentoView lancamentoView =  new LancamentoView();

    public Usuario login(){
        return usuarioView.telaLogin();
    }

    public void seleciona(int opcao, Usuario user) throws ParseException, SQLException {

        switch (opcao){
            case 1:
                usuarioView.telaCadastro();
                break;
            case 2:
                lancamentoView.menuLancamentoRenda(user);
                break;
            case 3:
                lancamentoView.menuLancamentoDespesa(user);
                break;
            case 4:
                lancamentoView.visualizaRenda(user);
                break;
            case 5:
                lancamentoView.visualizaDespesa(user);
                break;
            case 6:
                lancamentoView.visualizaMes(user);
                break;
            case 7:
                System.exit(0);
                break;
        }
    }
}

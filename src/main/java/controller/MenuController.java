package controller;

import models.classes.Usuario;
import view.LancamentoView;
import view.UsuarioView;

import java.sql.SQLException;
import java.text.ParseException;

public class MenuController {

    private UsuarioView usuarioView;
    private LancamentoView lancamentoView;

    public MenuController (){
        usuarioView = new UsuarioView();
        lancamentoView =  new LancamentoView();
    }

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
                lancamentoView.visualizaTodasRendas(user);
                break;
            case 5:
                lancamentoView.visualizaTodasDespesas(user);
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

package controller;

import model.classes.Usuario;
import view.LancamentoView;
import view.MenuView;
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

    public void selecionaLogin(int opcao){
        MenuView menuView = new MenuView();
        switch (opcao){
            case 1:
                usuarioView.telaCadastroUsuario();
                break;
            case 2:
                menuView.menu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public Usuario login(){
        return usuarioView.telaLogin();
    }

    public void selecionaPrincipal(int opcao, Usuario user) throws ParseException, SQLException {

        switch (opcao){
            case 1:
                usuarioView.telaCadastroUsuario();
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

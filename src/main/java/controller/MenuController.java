package controller;

import models.classes.Usuario;
import view.LancamentoView;
import view.UsuarioView;

import java.sql.SQLException;
import java.text.ParseException;

public class MenuController {

    public void seleciona(int opcao, Usuario user) throws ParseException, SQLException {
        UsuarioView cadastroUsuario = new UsuarioView();
        LancamentoView lancamentoView =  new LancamentoView();


        switch (opcao){
            case 1:
                cadastroUsuario.telaCadastro();
                break;
            case 2:
                lancamentoView.menuLancamentoRenda(user);
                break;
            case 3:
                lancamentoView.menuLancamentoDespesa(user);
                break;
            case 4:
                lancamentoView.visualizaDespesa(user);
                break;
            case 5:
                lancamentoView.visualizaRenda(user);
                break;
            case 6:
                lancamentoView.visualizaMes(user);
                break;
            case 7:
                System.exit(0);
                break;
        }

    }

    public Usuario login(){
        UsuarioView usuarioView = new UsuarioView();

        return usuarioView.telaLogin();
    }

}

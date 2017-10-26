package Controller;

import Models.Classes.Usuario;
import View.LancamentoView;
import View.UsuarioView;

import java.text.ParseException;

public class MenuController {

    public void seleciona(int opcao, Usuario user) throws ParseException {
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
                lancamentoView.menuVisualizaValor(user);
                break;
        }

    }

}

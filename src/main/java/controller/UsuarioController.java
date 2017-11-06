package controller;

import model.classes.Usuario;
import model.factory.ConnectionFactory;
import model.dao.UsuarioDAO;
import model.services.UsuarioService;
import view.UsuarioView;

public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioDAO usuarioDAO;

    public UsuarioController(){
        usuarioDAO = new UsuarioDAO(ConnectionFactory.getConnection());
        usuarioService = new UsuarioService(usuarioDAO);
    }

    public void cadastraUsuario(String nome){
        UsuarioView usuarioView = new UsuarioView();

        boolean verificacao = usuarioService.cadastraUsuario(nome);

        String novoNome;

        while(verificacao){
            novoNome = usuarioView.solicitaNovamente();
            verificacao = usuarioService.cadastraUsuario(novoNome);
        }

    }

    public Usuario verificaUsuario(String nome){
        Usuario user= usuarioService.verificaUsuario(nome);
        return user;
    }
}

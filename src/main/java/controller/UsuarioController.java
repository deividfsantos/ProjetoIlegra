package controller;

import models.classes.Usuario;
import models.factory.ConnectionFactory;
import models.dao.UsuarioDAO;
import models.services.UsuarioService;
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

        boolean verificacao = usuarioService.cadastra(nome);

        String novoNome;

        while(verificacao){
            novoNome = usuarioView.solicitaNovamente();
            verificacao = usuarioService.cadastra(novoNome);
        }

    }

    public Usuario verificaUsuario(String nome){
        Usuario user= usuarioService.verificaUsuario(nome);
        return user;
    }
}

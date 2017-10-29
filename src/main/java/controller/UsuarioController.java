package controller;

import models.classes.Usuario;
import models.factory.ConnectionFactory;
import models.dao.UsuarioDAO;
import view.UsuarioView;

public class UsuarioController {

    UsuarioDAO userDAO = new UsuarioDAO(ConnectionFactory.getConnection());

    public void cadastraUsuario(String nome){
        UsuarioView usuarioView = new UsuarioView();
        String nomeFinal = nome;
        boolean verificacao = userDAO.verificaUsuario(nome);

        while(verificacao){
            nomeFinal = usuarioView.solicitaNovamente();
            verificacao = userDAO.verificaUsuario(nomeFinal);
        }

        userDAO.cadastrar(nomeFinal);
    }

    public Usuario verificaUsuario(String nome){
        Usuario user= userDAO.retornaUsuario(nome);
        return user;

    }

}

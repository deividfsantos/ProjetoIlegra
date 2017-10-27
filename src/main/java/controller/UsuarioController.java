package controller;

import models.classes.Usuario;
import models.factory.ConnectionFactory;
import models.dao.UsuarioDAO;

public class UsuarioController {

    UsuarioDAO userDAO = new UsuarioDAO(ConnectionFactory.getConnection());

    public void cadastraUsuario(String nome){
        userDAO.cadastrar(nome);
    }

    public Usuario verificaUsuario(String nome){
        Usuario user= userDAO.retornaUsuario(nome);
        return user;

    }

}

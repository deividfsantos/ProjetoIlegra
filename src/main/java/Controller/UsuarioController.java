package Controller;

import Models.Classes.Usuario;
import Models.Factory.ConnectionFactory;
import Models.Services.UsuarioDAO;
import View.MenuView;

import java.sql.Connection;

public class UsuarioController {

    UsuarioDAO userDAO = new UsuarioDAO(ConnectionFactory.getConnection());

    public void cadastraUsuario(String nome){
        userDAO.cadastrar(nome);
    }

}

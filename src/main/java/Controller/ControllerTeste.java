package Controller;

import Models.Classes.Usuario;
import Models.Services.UsuarioDAO;

import java.sql.Connection;

public class ControllerTeste {

    Connection con;
    UsuarioDAO userDAO;
    Usuario user;

    public ControllerTeste(Connection con, UsuarioDAO userDAO, Usuario user) {
        this.con = con;
        this.userDAO = userDAO;
        this.user = user;
    }

    public void cadastra(Usuario user){
        userDAO.cadastrar(user);
    }

}

package models.services;

import models.dao.UsuarioDAO;
import models.factory.ConnectionFactory;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO(ConnectionFactory.getConnection());

    public boolean cadastra(String nome){

        boolean verificacao1 = usuarioDAO.verificaUsuario(nome);
        boolean verificacao2 = validaDadosCorretos(nome);

        if(verificacao1 || !verificacao2){
            return true;
        }

        usuarioDAO.cadastrar(nome);

        return false;
    }


    public boolean validaDadosCorretos(String nome){

        if(Character.isAlphabetic((nome.charAt(0))) && Character.isAlphabetic((nome.charAt(nome.length() - 1)))){
            return true;
        }
        return false;
    }

}

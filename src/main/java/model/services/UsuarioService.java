package model.services;

import model.classes.Usuario;
import model.dao.UsuarioDAO;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }

    public boolean cadastraUsuario(String nome){

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

    public Usuario verificaUsuario(String nome){
        Usuario user= usuarioDAO.retornaUsuario(nome);
        return user;
    }

}

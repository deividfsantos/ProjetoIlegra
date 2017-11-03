package models.dao;

import models.classes.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void cadastrar(String nome){
        Usuario usuario = new Usuario(nome);
        String sql = "INSERT INTO usuario (nome_usuario)"+" VALUES (?)";
        try {

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,usuario.getNomeUsuario());
            preparador.execute();
            preparador.close();

        } catch (SQLException e) {

            System.out.println("Não foi possível salvar nos ba " +
                    "nco "+e.getMessage());
        }
    }

    public Usuario retornaUsuario(String nome){
        String sql = "select * from usuario where nome_usuario= (?)";

        String nomeUser = "";
        int codigo = 0;

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,nome);
            ResultSet resultado = preparador.executeQuery();
            while(resultado.next()){
                nomeUser= resultado.getString("nome_usuario");
                codigo = resultado.getInt("cod_usuario");
            }
            preparador.close();

        }catch (SQLException e){
            System.out.println("Não foi possível encontrar o usuario: "+e.getMessage());
        }

        Usuario user = new Usuario(nomeUser, codigo);

        return user;
    }

    public boolean verificaUsuario(String nome){
        String sql = "select * from usuario where nome_usuario= (?)";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,nome);
            ResultSet resultado = preparador.executeQuery();
            if(resultado.next()){
                preparador.close();
                return true;

            }else{
                preparador.close();
                return false;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return true;
    }

}


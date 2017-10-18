package DAO;

import Models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void cadastrar(Usuario usuario){
        String sql = "INSERT INTO usuario" +" (nome_usuario)"+" VALUES (?)";
        try {

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,usuario.getUserName());
            preparador.execute();
            preparador.close();
            System.out.println("Dados salvos com sucesso");

        } catch (SQLException e) {

            System.out.println("Não foi possível salvar nos banco "+e.getMessage());

        }
    }

    public void visualizar(){

        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "select * from usuario ";


        try{
            PreparedStatement preparador = con.prepareStatement("select * from usuario ");

            ResultSet rs = preparador.executeQuery();

            while(rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setUserName(rs.getString("nome_usuario"));
                usuarios.add(usuario);

            }

        } catch (SQLException e){
            System.out.println("Não foi possível verificar "+e.getMessage());
        }
        for (int i = 0; i < usuarios.size(); i++) {

            System.out.println(""+usuarios.get(i));
        }

    }


}


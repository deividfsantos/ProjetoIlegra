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
        String sql = "INSERT INTO usuario (nome_usuario)"+" VALUES (?)";
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

    public void visualizarTodos(){

        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "select * from usuario ";


        try{
            PreparedStatement preparador = con.prepareStatement(sql);

            ResultSet rs = preparador.executeQuery();

            while(rs.next()) {
                String nome= rs.getString("nome_usuario");
                int codigo = rs.getInt("cod_usuario");
                Usuario usuario = new Usuario(nome, codigo);
                usuarios.add(usuario);
            }
            preparador.close();
        } catch (SQLException e){
            System.out.println("Não foi possível verificar "+e.getMessage());
        }
        for (int i = 0; i < usuarios.size(); i++) {

            System.out.println(""+usuarios.get(i));
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


}


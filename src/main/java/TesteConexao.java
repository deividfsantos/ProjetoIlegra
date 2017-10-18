
import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Models.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {



        Connection con = new ConnectionFactory().getConnection();


        Usuario user = new Usuario("Deivid");
        UsuarioDAO envia= new UsuarioDAO(con);

        envia.visualizar();



        con.close();

    }


}

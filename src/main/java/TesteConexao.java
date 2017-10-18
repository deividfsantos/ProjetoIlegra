
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {



        Connection con = new ConnectionFactory().getConnection();


        Usuario user = new Usuario("Joao");
        UsuarioDAO envia= new UsuarioDAO(con);
        envia.cadastrar(user);



        con.close();

    }


}

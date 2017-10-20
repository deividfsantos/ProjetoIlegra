
import DAO.RendaDAO;
import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Models.Renda;
import Models.Usuario;

import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ParseException {



        Connection con = ConnectionFactory.getConnection();

        Usuario user = new Usuario("Deivid");

        UsuarioDAO envia= new UsuarioDAO(con);



        envia.visualizarTodos();





        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Date dataf = formatador.parse("24/2/2000");


        Usuario usuario = envia.retornaUsuario("Luiz");

        Renda renda = new Renda(100, "Teste10", "a", dataf, usuario);

        RendaDAO enviaRenda = new RendaDAO(con);

        envia.retornaUsuario("teste");
        enviaRenda.insertRenda(renda);

        con.close();

    }

}

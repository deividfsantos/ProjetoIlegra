import models.dao.UsuarioDAO;
import models.factory.ConnectionFactory;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;

public class UsuarioTeste {

    @Test
    public void testaBuscaUsuario(){

        Connection con = ConnectionFactory.getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        String esperado = "deivid";
        int codEsperado = 10;

        String retorno = usuarioDAO.retornaUsuario(esperado).getNomeUsuario().toLowerCase();
        int cod = usuarioDAO.retornaUsuario(esperado).getCodigoUsuario();

        assertEquals(esperado, retorno);
        assertEquals(codEsperado, cod);

    }


}

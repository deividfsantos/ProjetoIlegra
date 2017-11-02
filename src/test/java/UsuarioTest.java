import models.dao.UsuarioDAO;
import models.factory.ConnectionFactory;
import models.services.UsuarioService;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;

public class UsuarioTest {

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

    @Test
    public void testaValidacaoFalsa(){
        UsuarioService usuarioService = new UsuarioService();
        String nome = "@$#%#";
        boolean teste= usuarioService.validaDadosCorretos(nome);
        assertFalse(teste);
    }

    @Test
    public void testaValidacaoVerdadeira(){
        UsuarioService usuarioService = new UsuarioService();
        String nome = "deivid";
        boolean teste= usuarioService.validaDadosCorretos(nome);
        assertTrue(teste);
    }
}

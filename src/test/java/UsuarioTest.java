
import models.classes.Usuario;
import models.dao.UsuarioDAO;
import models.services.UsuarioService;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UsuarioTest {

    @Test
    public void testaBuscaUsuario(){

        String esperado = "deivid";
        int codEsperado = 1;

        Usuario user = new Usuario(esperado,codEsperado);

        UsuarioDAO usuarioDAO= mock(UsuarioDAO.class);

        when(usuarioDAO.retornaUsuario(esperado)).thenReturn(user);

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

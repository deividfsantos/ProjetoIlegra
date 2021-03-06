
import model.classes.Usuario;
import model.dao.UsuarioDAO;
import model.services.UsuarioService;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UsuarioTest {

    private UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);

    @Test
    public void testaCadastroUsuario(){
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);

        String nome = "#&@#";
        when(usuarioDAO.verificaUsuario(nome)).thenReturn(false);
        assertTrue(usuarioService.cadastraUsuario(nome));

        String nome2 = "Deivid";
        when(usuarioDAO.verificaUsuario(nome2)).thenReturn(true);
        assertTrue(usuarioService.cadastraUsuario(nome2));

        String nome3 = "NomeNovo";
        when(usuarioDAO.verificaUsuario(nome3)).thenReturn(false);
        assertFalse(usuarioService.cadastraUsuario(nome3));
    }

    @Test
    public void testaValidacaoFalsa(){
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        String nome = "@$#%#";
        boolean teste= usuarioService.validaDadosCorretos(nome);
        assertFalse(teste);
    }

    @Test
    public void testaValidacaoVerdadeira(){
        UsuarioService usuarioService = new UsuarioService(usuarioDAO);
        String nome = "deivid";
        boolean teste= usuarioService.validaDadosCorretos(nome);
        assertTrue(teste);
    }

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

}

import models.classes.Lancamento;
import models.classes.Usuario;
import models.dao.LancamentoDAO;
import models.factory.ConnectionFactory;
import models.services.LancamentoService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LancamentoTest {

    @Test
    public void testeMostraTotal(){

        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(new Lancamento(500,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(600,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(100,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(200,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(300,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(500,"Teste 1", null, null, null, 0, ""));
        LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        double inicial =  lancamentoService.calculaTotal(lancamentos);
        double esperado = 500+600+100+200+300+500;
        assertEquals(inicial, esperado, 0.000001);
    }

    @Test
    public void testeRetornaTotalDespesa() throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        double esperado = 0;
        Usuario user = new Usuario("UsuarioTestes",666);
        LancamentoDAO lancamentoDAO = new LancamentoDAO(con);
        ArrayList<Lancamento> lancamentos = lancamentoDAO.visualizaValores(user, "d", "a");

        double valor = 0;
        for (int i = 0; i < lancamentos.size(); i++) {
            valor += lancamentos.get(i).getValor();
        }

        assertEquals(esperado, valor,0.000001);
    }

    @Test
    public void testaMultiplosLancamentos(){

    }

}

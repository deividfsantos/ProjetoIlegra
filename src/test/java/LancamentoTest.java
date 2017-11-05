import models.classes.Lancamento;
import models.classes.Usuario;
import models.dao.LancamentoDAO;
import models.factory.ConnectionFactory;
import adjustments.DataAdjustment;
import models.services.LancamentoService;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class LancamentoTest {

    private LancamentoDAO lancamentoDAO = mock(LancamentoDAO.class);

    @Test
    public void testeMostraTotal(){
        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(new Lancamento(500,"Teste 1", null, null, null, 0, ""));
        lancamentos.add(new Lancamento(600,"Teste 1", null, null, null, 0, ""));
        LancamentoDAO lancamentoDAO = new LancamentoDAO(ConnectionFactory.getConnection());
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        double inicial =  lancamentoService.calculaTotal(lancamentos);
        double esperado = 500+600;
        assertEquals(inicial, esperado, 0.000001);
    }

    @Test
    public void testeRetornaTotalDespesa() throws SQLException {
        Usuario user = new Usuario("UsuarioTestes",5);
        Lancamento lancamento1 = new Lancamento(100,"Teeste","r",null ,user,10,"p");
        Lancamento lancamento2 = new Lancamento(100,"Teeste","r",null ,user,10,"p");
        LancamentoDAO lancamentoDAO = mock(LancamentoDAO.class);
        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(lancamento1);
        lancamentos.add(lancamento2);
        when(lancamentoDAO.visualizaValores(user, "p", "r")).thenReturn(lancamentos);
        ArrayList<Lancamento> arrayList = lancamentoDAO.visualizaValores(user, "p", "r");
        assertEquals(lancamentos, arrayList);
    }

    @Test
    public void testaLancamentoParcelado() throws SQLException, ParseException {
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        Date data= DataAdjustment.regulaData(11,2017);
        Usuario user = new Usuario("UsuarioTestes",5);
        Lancamento lancamento = new Lancamento(100,"Teeste","r", data, user,7,"p");
        lancamentoService.inserirLancamento(lancamento);
        verify(lancamentoDAO).inserirUmLancamento(lancamento, 6);
    }

    @Test
    public void testaLancamentoFixo() throws SQLException, ParseException {
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        Date data= DataAdjustment.regulaData(11,2017);
        Usuario user = new Usuario("UsuarioTestes",666);
        Lancamento lancamento = new Lancamento(100,"Teeste","r", data, user,12,"f");
        lancamentoService.inserirLancamento(lancamento);
        verify(lancamentoDAO).inserirUmLancamento(lancamento, 11);
    }

}

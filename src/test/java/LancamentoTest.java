import model.classes.Lancamento;
import model.classes.Usuario;
import model.dao.LancamentoDAO;
import model.factory.ConnectionFactory;
import adjustments.DataAdjustment;
import model.services.LancamentoService;
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
    public void testaInserirLancamentoParcelado() throws SQLException, ParseException {
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        Date data= DataAdjustment.regulaData(11,2017);
        Usuario user = new Usuario("UsuarioTestes",5);
        Lancamento lancamento = new Lancamento(100,"Teeste","r", data, user,7,"p");
        lancamentoService.inserirLancamento(lancamento);
        verify(lancamentoDAO).inserirUmLancamento(lancamento, 6);
    }

    @Test
    public void testaInserirLancamentoFixo() throws SQLException, ParseException {
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        Date data= DataAdjustment.regulaData(11,2017);
        Usuario user = new Usuario("UsuarioTestes",666);
        Lancamento lancamento = new Lancamento(100,"Teeste","r", data, user,12,"f");
        lancamentoService.inserirLancamento(lancamento);
        verify(lancamentoDAO).inserirUmLancamento(lancamento, 11);
    }

    @Test
    public void testaRetornaMes() throws SQLException, ParseException {
        Date dataUtil = DataAdjustment.regulaData(01, 2017);
        java.sql.Date dataSQL = DataAdjustment.converte(dataUtil);

        Usuario user = new Usuario("UsuarioTestes",5);
        Lancamento lancamento1 = new Lancamento(100,"Teeste","r",null ,user,10,"p");
        Lancamento lancamento2 = new Lancamento(100,"Teeste","r",null ,user,10,"p");
        ArrayList lancamentoParcelado =  new ArrayList();
        lancamentoParcelado.add(lancamento1);
        lancamentoParcelado.add(lancamento2);
        Lancamento lancamento4 = new Lancamento(100,"Teeste","r",null ,user,10,"a");
        ArrayList lancamentoAVista =  new ArrayList();
        lancamentoAVista.add(lancamento4);
        ArrayList teste = new ArrayList();
        teste.add(lancamento4);
        teste.add(lancamento1);
        teste.add(lancamento2);

        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        when(lancamentoDAO.visualizaValores(dataSQL, user, "r", "p")).thenReturn(lancamentoParcelado);
        when(lancamentoDAO.visualizaValores(dataSQL, user, "r", "a")).thenReturn(lancamentoAVista);

        ArrayList testeMetodo = lancamentoService.retornaMes(user, 01,2017, "r");
        assertEquals(teste, testeMetodo);
    }

    @Test
    public void testeCalculaTotal(){
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
    public void testaCalculaRestante(){
        LancamentoService lancamentoService = new LancamentoService(lancamentoDAO);
        double valorEsperado = 200;
        double valorFinal =  lancamentoService.calculaRestante(355.5,155.5);
        assertEquals(valorEsperado, valorFinal, 0.000001);
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






}

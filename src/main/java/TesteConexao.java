
import DAO.LancamentoDAO;
import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Models.Lancamento;
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


        Date dataf =  new SimpleDateFormat("dd/MM/yyyy").parse("24/12/2017");

        Usuario usuario = envia.retornaUsuario("Luiz");

        Lancamento lancamento = new Lancamento(100, "T", "a", dataf, usuario);

        LancamentoDAO enviaLancamento = new LancamentoDAO(con);

        envia.retornaUsuario("teste");
        enviaLancamento.inserirLancamento(lancamento);

        con.close();

    }

}

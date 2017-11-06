import model.factory.ConnectionFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionTest {

    @Test
    public void testaConexao() throws SQLException {
        ConnectionFactory.getConnection();
        assertTrue(ConnectionFactory.getStatusConexao());
    }

}

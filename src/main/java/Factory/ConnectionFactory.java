package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String local = "jdbc:mysql://localhost/projeto_financeiro";
    String usuario = "root";

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(local,usuario, "");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}

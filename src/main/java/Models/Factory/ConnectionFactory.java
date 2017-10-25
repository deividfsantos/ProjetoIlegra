package Models.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {



    public static Connection getConnection(){
        String local = "jdbc:mysql://localhost/projeto_financeiro?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String usuario = "root";
        String pass = "root";

        try {
            return DriverManager.getConnection(local,usuario, pass);
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}

package models.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String local = "jdbc:mysql://localhost/projeto_financeiro?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String usuario = "root";
    private static final String pass = "root";
    private static boolean status;

    public static Connection getConnection(){
        try {
            status=true;
            return DriverManager.getConnection(local,usuario, pass);
        } catch (SQLException excecao) {
            status=false;
            throw new RuntimeException(excecao);
        }
    }

    public static boolean getStatusConexao(){
        return status;
    }
}


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection con;
    public UsuarioDAO(Connection con) {
        this.con = con;
    }
    public void cadastrar(Usuario usuario){
        String sql = "INSERT INTO usuario" +" (nome_usuario)"+" VALUES (?)";
        try {

            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1,usuario.getUserName());
            preparador.execute();
            preparador.close();
            System.out.println("Dados salvos com sucesso");

        } catch (SQLException e) {

            System.out.println("Não foi possível salvar nos banco "+e.getMessage());

        }
    }

}


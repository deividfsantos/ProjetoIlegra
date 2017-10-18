package Models;

public class Usuario {

    private String userName;

    public Usuario() {
    }

    public Usuario(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "\nModels.Usuario: " +
                "\nNome de usuário: " + userName+"\n";
    }
}

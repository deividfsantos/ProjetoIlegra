package Models;

public class Usuario {

    private String userName;
    private int codUser;

    public Usuario(String userName) {
        this.userName = userName;
    }

    public Usuario(String userName, int codUser) {
        this.userName = userName;
        this.codUser = codUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    @Override
    public String toString() {
        return "\nUsuario: " +
                "\nNome de usuário: " + userName+"\n";
    }
}

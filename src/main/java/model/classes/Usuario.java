package model.classes;

public class Usuario {

    private String nomeUsuario;
    private int codigoUsuario;

    public Usuario(String userName) {
        this.nomeUsuario = userName;
    }

    public Usuario(String userName, int codUser) {
        this.nomeUsuario = userName;
        this.codigoUsuario = codUser;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "\nUsuario: " +
                "\nNome de usuário: " + nomeUsuario +"\n";
    }
}

package view;

import controller.UsuarioController;
import model.classes.Usuario;
import java.util.Scanner;

public class UsuarioView {

    private UsuarioController usuarioController =new UsuarioController();
    Scanner input = new Scanner(System.in);

    public Usuario telaLogin(){
        System.out.print("Digite seu nome de usuário: ");
        String nome = input.nextLine();

        Usuario user = usuarioController.verificaUsuario(nome);

        while (user.getNomeUsuario().isEmpty()){
            System.out.print("Nome de usuário não encontrado\n\nPor favor digite seu nome novamente: ");
            nome = input.nextLine();
            user = usuarioController.verificaUsuario(nome);
        }
        return user;
    }

    public void telaCadastroUsuario() {
        System.out.print("\nDigite o novo nome de usuário: ");
        String nome = input.nextLine();

        usuarioController.cadastraUsuario(nome);
        System.out.print("\033[34;1mUsuário cadastrado com sucesso.\n\033[0m");
    }

    public String solicitaNovamente(){
        System.out.print("\nNome de usuário já existe ou está incorreto" +
                "\nPor favor, digite o nome novamente: ");
        return input.nextLine();
    }
}

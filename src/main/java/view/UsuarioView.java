package view;

import controller.UsuarioController;
import models.classes.Usuario;
import java.util.Scanner;

public class UsuarioView {

    Scanner input = new Scanner(System.in);
    UsuarioController usuarioController =new UsuarioController();

    public Usuario telaLogin(){
        System.out.print("Digite seu nome de usuário: ");
        String nome = input.next();

        Usuario user = usuarioController.verificaUsuario(nome);

        while (user.getNomeUsuario().isEmpty()){
            System.out.print("Nome de usuário não encontrado\n\nPor favor digite seu nome novamente: ");
            nome = input.next();
            user = usuarioController.verificaUsuario(nome);
        }

        return user;
    }

    public void telaCadastro() {
        System.out.print("Digite o nome do usuário que deseja cadastrar:");
        String nome = input.next();

        usuarioController.cadastraUsuario(nome);
        System.out.print("\033[34;1mUsuário cadastrado com sucesso.\n\033[0m");

    }

    public String solicitaNovamente(){
        System.out.print("\nNome de usuário já existe ou está incorreto" +
                "\nPor favor, digite o nome novamente: ");
        return input.next();
    }
}

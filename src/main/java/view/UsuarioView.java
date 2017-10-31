package view;

import controller.UsuarioController;
import models.classes.Usuario;
import java.util.Scanner;

public class UsuarioView {

    Scanner input = new Scanner(System.in);
    UsuarioController usuarioController =new UsuarioController();

    public Usuario telaLogin(){
        System.out.print("Digite seu nome de usuário: ");
        String nome = "Deivid";//input.next();

        Usuario user = usuarioController.verificaUsuario(nome);

        while (user.getNomeUsuario().isEmpty()){
            System.out.println("Nome de usuário não encontrado\n\nPor favor digite seu nome novamente: ");
            nome = input.next();
            user = usuarioController.verificaUsuario(nome);
        }

        return user;
    }

    public void telaCadastro() {
        System.out.println("Digite o nome do usuário que deseja cadastrar:");
        String nome = input.next();

        usuarioController.cadastraUsuario(nome);
        System.out.println("Usuário cadastrado com sucesso.");

    }

    public String solicitaNovamente(){
        System.out.println("\nNome de usuário já existe" +
                "\nPor favor, digite o nome novamente: ");
        return input.next();
    }
}

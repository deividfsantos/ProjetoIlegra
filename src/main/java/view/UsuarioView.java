package view;

import controller.UsuarioController;
import models.classes.Usuario;
import java.util.Scanner;

public class UsuarioView {

    Scanner input = new Scanner(System.in);
    UsuarioController userControl =new UsuarioController();

    public Usuario telaLogin(){
        System.out.println("Digite seu nome de usuário: ");
        String nome = input.next();

        Usuario user = userControl.verificaUsuario(nome);

        while (user.getNomeUsuario().isEmpty()){
            System.out.println("Nome de usuário não encontrado\n\nPor favor digite seu nome novamente: ");
            nome = input.next();
            user = userControl.verificaUsuario(nome);
        }

        return user;
    }

    public void telaCadastro() {
        System.out.println("Digite o nome do usuário que deseja cadastrar:");
        String nome = input.next();

        userControl.cadastraUsuario(nome);
        System.out.println("Usuário cadastrado com sucesso.");

    }

    public String solicitaNovamente(){
        System.out.println("\nNome de usuário já existe" +
                "\nPor favor, digite o nome novamente: ");
        return input.next();
    }
}

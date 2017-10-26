package View;

import Controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {

    Scanner input = new Scanner(System.in);
    UsuarioController userControl =new UsuarioController();

    public void telaCadastro() {

        System.out.println("Digite o nome do usuário que deseja cadas:");
        String nome = input.nextLine();

        userControl.cadastraUsuario(nome);
    }
}

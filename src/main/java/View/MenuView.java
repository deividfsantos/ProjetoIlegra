package View;

import Controller.MenuController;
import Models.Classes.Usuario;

import java.text.ParseException;
import java.util.Scanner;

public class MenuView {


    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        Usuario user = new Usuario("Deividz");
        MenuController controle = new MenuController();

        int opcao=0;

        while (opcao != 7) {

        System.out.println("\n1- Cadastrar usuario" +
                "\n2- Lançamento de renda" +
                "\n3- Lançamento de despesa" +
                "\n4- Visualizar despesas" +
                "\n5- Visualizar rendas" +
                "\n6- Visualizar mês" +
                "\n7- Sair");

        opcao = input.nextInt();
        controle.seleciona(opcao, user);
        }
    }

}

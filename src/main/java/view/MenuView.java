package view;

import controller.MenuController;
import models.classes.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuView {


    public static void main(String[] args) throws ParseException, SQLException {

        Scanner input = new Scanner(System.in);
        MenuController menuController = new MenuController();

        Usuario user = menuController.login();

        int opcao=0;

        System.out.println("\n\n\033[34;1m********BEM VINDO********\033[0m");

        while (opcao != 7) {

            System.out.print("\nEscolha a opção desejada" +
                    "\n1- Cadastrar usuario" +
                    "\n2- Lançamento de renda" +
                    "\n3- Lançamento de despesa" +
                    "\n4- Visualizar despesas" +
                    "\n5- Visualizar rendas" +
                    "\n6- Visualizar mês" +
                    "\n7- Sair" +
                    "\nDigite a opção: ");

            opcao = input.nextInt();
            System.out.println("\n");

            while(opcao>7 || opcao<1 ){
                System.out.println("Opção incorreta, digite novamente: ");
                opcao = input.nextInt();
            }
            menuController.seleciona(opcao, user);
        }

    }

}

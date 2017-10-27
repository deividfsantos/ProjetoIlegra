package view;

import controller.MenuController;
import models.classes.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuView {


    public static void main(String[] args) throws ParseException, SQLException {

        Scanner input = new Scanner(System.in);
        MenuController controle = new MenuController();
        Usuario user = controle.login();

        int opcao=0;

        while (opcao != 7) {
            System.out.print("\n1- Cadastrar usuario" +
                    "\n2- Lançamento de renda" +
                    "\n3- Lançamento de despesa" +
                    "\n4- Visualizar despesas" +
                    "\n5- Visualizar rendas" +
                    "\n6- Visualizar mês" +
                    "\n7- Sair" +
                    "\nDigite a opção: ");
            opcao = input.nextInt();
            System.out.println("\n");
            controle.seleciona(opcao, user);
        }
    }

}

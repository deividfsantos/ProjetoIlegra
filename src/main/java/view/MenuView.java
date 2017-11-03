package view;

import controller.MenuController;
import models.classes.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuView {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        MenuController menuController = new MenuController();
        System.out.println("\n\n\033[32;1m**********MELHOR SISTEMA FINANCEIRO DO MUNDO**********\033[0m");
        Usuario user = menuController.login();
        int opcao=0;
        System.out.println("\n\n\033[32;1m**********BEM VINDO**********\033[0m");
        while (opcao != 7) {
            try {
                System.out.print("\nEscolha a opção desejada" +
                        "\n1- Cadastrar usuario" +
                        "\n2- Lançamento de renda" +
                        "\n3- Lançamento de despesa" +
                        "\n4- Visualizar rendas" +
                        "\n5- Visualizar despesas" +
                        "\n6- Visualizar mês" +
                        "\n7- Sair" +
                        "\nDigite a opção: ");

                opcao = Integer.parseInt(input.nextLine());

                while (opcao > 7 || opcao < 1) {
                    System.out.print("Opção incorreta, digite novamente: ");
                    opcao = Integer.parseInt(input.nextLine());
                }
                System.out.print("\n");
                menuController.seleciona(opcao, user);
            }catch (SQLException e){
                System.out.println("Não foi possivel efetuar a opração, tente novamente");
            }
        }

    }

}

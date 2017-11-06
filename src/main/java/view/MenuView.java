package view;

import controller.MenuController;
import model.classes.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuView {

    Scanner input = new Scanner(System.in);
    MenuController menuController = new MenuController();

    public void login(){
        int opcao=0;
        while(opcao!= 3) {
            System.out.print("\n\nSelecione a opção desejada: " +
                    "\n1 - Cadastrar novo Usuario" +
                    "\n2 - Login" +
                    "\n3 - Sair" +
                    "\nDigite a opção: ");
            opcao = input.nextInt();
            menuController.selecionaLogin(opcao);
        }
    }

    public void menu(){
        System.out.println("\n\n\033[32;1m**********CONTROLE FINANCEIRO MENSAL**********\033[0m");
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
                menuController.selecionaPrincipal(opcao, user);
            }catch (SQLException e){
                System.out.println("Não foi possivel efetuar a opração, tente novamente");
            } catch (ParseException e) {
                System.out.println("Erro no valor digitado");
            }
        }
    }


}

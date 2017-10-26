/*package View;

import Controller.MenuController;
import Models.Services.LancamentoDAO;
import Models.Services.UsuarioDAO;
import Models.Classes.Lancamento;
import Models.Classes.Usuario;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ViewTeste {

    public static void main(String[] args) throws SQLException, ParseException {
        Scanner input = new Scanner(System.in);
        MenuController controle = new MenuController();

        //Menus
        System.out.println("**** Digite a opção desejada ****" +
                "\n1- Login" +
                "\n2- Sair");
        int opcaoInicio = input.nextInt();


        switch (opcaoInicio) {
            case 1:

            System.out.println("Digite seu nome de usuário: ");
            String nome = input.next();
                while (!(userDao.retornaUsuarioTrue(nome))){
                    System.out.println("Nome de usuário inexistente\n\nDigite seu nome de usuário: ");
                    nome = input.next();
                }

                int opcao = 0;
                while (opcao != 8) {



                    switch (opcao) {
                        case 1:
                            System.out.println("\nDigite o nome do usuário: ");
                            String nomeUser = input.next();
                            Usuario user = new Usuario(nomeUser);
                            controle.cadastra(user);
                            break;
                        case 2:
                            System.out.println("\n\n--------Lançamento de renda--------\n");
                            lancaValor(userDao.retornaUsuario(nome), lancamentoDAO, "r");
                            System.out.println("\nLançamento efetuado com sucesso.\n");
                            break;
                        case 3:
                            System.out.println("\n\n--------Lançamento de despesa--------\n");
                            lancaValor(userDao.retornaUsuario(nome), lancamentoDAO, "d");
                            System.out.println("\nLançamento efetuado com sucesso.\n");
                            break;
                        case 4:
                            System.out.println("\n\n--------Visualização de despesas--------\n");
                            exibeLancamento(con, input, userDao, nome, "d");
                            break;
                        case 5:
                            System.out.println("\n\n--------Visualização de rendas--------\n");
                            exibeLancamento(con, input, userDao, nome, "r");
                            break;
                        case 6:
                            visualizaMes(input, userDao, lancamentoDAO, nome);
                            break;
                        case 7:
                            System.exit(0);
                            break;
                    }
                }
            con.close();
                break;
            case 2:
                System.exit(0);
        }

    }

    private static void visualizaMes(Scanner input, UsuarioDAO userDao, LancamentoDAO lancamentoDAO, String nome) throws SQLException {
        System.out.println("\n\n--------Visualizar Mes--------\n");
        System.out.println("Digite o mês: ");
        int mes = input.nextInt();
        System.out.println("Digite o ano: ");
        int ano = input.nextInt();
        lancamentoDAO.visualizarMes(mes, ano, userDao.retornaUsuario(nome));
    }

    private static void exibeLancamento(Connection con, Scanner input, UsuarioDAO userDao, String nome, String tipoLancamento) throws SQLException {
        System.out.println("F- Visualizar fixas\nV- Visualizar variáveis");

        String tipo = input.next();

        System.out.println("Digite o mês: ");
        int mes = input.nextInt();
        System.out.println("Digite o ano: ");
        int ano = input.nextInt();
        LancamentoDAO visualizador = new LancamentoDAO(con);
        if(tipo.equalsIgnoreCase("v")){
            visualizador.visualizaValores(mes, ano, userDao.retornaUsuario(nome), tipoLancamento, "p");
            visualizador.visualizaValores(mes, ano, userDao.retornaUsuario(nome), tipoLancamento, "a");
        }else{
            visualizador.visualizaValores(mes, ano, userDao.retornaUsuario(nome), tipoLancamento, tipo);
        }
    }



    private static void lancaValor(Usuario user, LancamentoDAO lancamentoDAO, String tipo) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Deseja lançar qual tipo?\nFixa - F\nVariável - V");
        String tipoVar = input.next();

        while((!(tipoVar.equalsIgnoreCase("v")))&&(!(tipoVar.equalsIgnoreCase("f")))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoVar=input.next();
        }

        System.out.println("Digite a descrição desse lancamento: ");
        String desc = input.next();

        System.out.println("Digite o valor:");
        double valor= input.nextDouble();

        System.out.println("Digite o mês inicial: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano inicial: ");
        int ano = input.nextInt();

        if(tipoVar.equalsIgnoreCase("f")){

            Lancamento lancamentoFixo = new Lancamento(valor, desc, tipo, regulaData(mes, ano), user);
            lancamentoDAO.inserirLancamento(lancamentoFixo);

        }else if(tipoVar.equalsIgnoreCase("v")){
            lancaVariavel(user, lancamentoDAO, tipo, input, tipoVar, desc, valor, mes, ano);
        }

    }

    private static void lancaVariavel(Usuario user, LancamentoDAO lancamentoDAO, String tipo, Scanner input, String tipoVar, String desc, double valor, int mes, int ano) throws ParseException {
        System.out.println("Digite o tipo de parcela do lançamento:\nP- Parcelada\nA- A vista");
        String tipoParcelas = input.next();

        while((!(tipoParcelas.equalsIgnoreCase("p")))&&(!(tipoVar.equalsIgnoreCase("a")))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoParcelas=input.next();
        }

        int parcelas = 1;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.println("Digite a quantidade de parcelas: ");
            parcelas = input.nextInt();
        }

        Lancamento lancamentoVariavel = new Lancamento(valor, desc, tipo, regulaData(mes, ano), user, parcelas, tipoParcelas);
        lancamentoDAO.inserirLancamento(lancamentoVariavel);
    }



}
*/
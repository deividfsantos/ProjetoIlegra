
import DAO.LancamentoDAO;
import DAO.UsuarioDAO;
import Factory.ConnectionFactory;
import Models.Lancamento;
import Models.Usuario;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ParseException {

        Connection con = ConnectionFactory.getConnection();
        Scanner input = new Scanner(System.in);
        UsuarioDAO userDao = new UsuarioDAO(con);
        LancamentoDAO lancamentoDAO = new LancamentoDAO(con);

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
                    System.out.print("\nDigite a opção desejada" +
                            "\n1- Cadastrar novo usuário" +
                            "\n2- Visualizar dados de usuário" +
                            "\n3- Cadastrar renda" +
                            "\n4- Cadastrar despesa" +
                            "\n5- Visualizar despesas" +
                            "\n6- Visualizar renda" +
                            "\n7- Visualizar valores totais" +
                            "\n8- Sair da aplicação\nDigite a opção: ");
                    opcao = input.nextInt();


                    switch (opcao) {
                        case 1:
                            cadastraUsuario(input, userDao);
                            break;
                        case 2:
                            System.out.println(userDao.retornaUsuario(nome));
                            break;
                        case 3:
                            System.out.println("\n\n--------Lançamento de renda--------\n");
                            lanca(userDao.retornaUsuario(nome), lancamentoDAO, "r");
                            System.out.println("\nLançamento efetuado com sucesso.\n");
                            break;
                        case 4:
                            System.out.println("\n\n--------Lançamento de despesa--------\n");
                            lanca(userDao.retornaUsuario(nome), lancamentoDAO, "d");
                            System.out.println("\nLançamento efetuado com sucesso.\n");
                            break;
                    }
                }
            con.close();
                break;
            case 2:
                System.exit(0);
        }

    }

    private static void cadastraUsuario(Scanner input, UsuarioDAO userDao) {
        System.out.println("\nDigite o nome do usuário: ");
        String nomeUser = input.next();
        Usuario user = new Usuario(nomeUser);
        userDao.cadastrar(user);
    }

    private static void lanca(Usuario user, LancamentoDAO rendaDao, String tipo) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja lançar qual tipo?\nFixa - F\nVariável - V");

        String tipoVar = input.next();
        while((!(tipoVar.equalsIgnoreCase("v")))&&(!(tipoVar.equalsIgnoreCase("f")))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoVar=input.next();
        }

        if(tipoVar.equalsIgnoreCase("f")){

            lancaFixo(user, rendaDao, tipo);
        }else{
            lancaVariavel(user, rendaDao, tipo);
        }
    }

    private static void lancaFixo(Usuario user, LancamentoDAO lancamentoDAO, String tipo) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite a descrição desse lancamento: ");
        String desc = input.nextLine();

        System.out.println("Digite o valor:");
        double valor= input.nextDouble();

        System.out.println("Digite o mês inicial: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano inicial: ");
        int ano = input.nextInt();

        Lancamento rendaFixa = new Lancamento(valor, desc, tipo, regulaData(mes, ano), user);
        lancamentoDAO.inserirLancamento(rendaFixa);
    }

    private static void lancaVariavel(Usuario user, LancamentoDAO lancamentoDAO, String tipo) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite a descrição desse lançamento: ");
        String desc = input.nextLine();

        System.out.println("Digite o valor total:");
        double valor= input.nextDouble();

        System.out.println("Digite o mês inicial: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano inicial: ");
        int ano = input.nextInt();

        System.out.println("Digite o tipo de parcela do lançamento:\nP- Parcelada\nA- A vista");
        String tipoParcelas = input.next();

        String tipoVar = input.next();
        while((!(tipoParcelas.equalsIgnoreCase("p")))&&(!(tipoVar.equalsIgnoreCase("a")))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoParcelas=input.next();
        }

        int parcelas = 1;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.println("Digite a quantidade de parcelas: ");
            parcelas = input.nextInt();
        }

        Lancamento rendaFixa = new Lancamento(valor, desc, tipo, regulaData(mes, ano), user, parcelas, tipoParcelas);
        lancamentoDAO.inserirLancamento(rendaFixa);
    }

    private static Date regulaData(int mes, int ano) throws ParseException {
        String valor = "12/"+mes+"/"+ano;

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(valor);
        return data;

    }

}

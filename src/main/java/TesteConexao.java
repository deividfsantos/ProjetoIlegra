
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
        UsuarioDAO userDao= new UsuarioDAO(con);

        //Menus
        System.out.println("**** Digite a opção desejada ****" +
                "1- Login" +
                "2- Sair");

        userDao.retornaUsuario("Deivid");


        System.out.println("Digite a opção desejada" +
                "\n1- Cadastrar novo usuário" +
                "\n2- Visualizar dados de usuário" +
                "\n3- Cadastrar renda" +
                "\n4- Cadastrar despesa" +
                "\n5- Visualizar despesas" +
                "\n6- Visualizar renda" +
                "\n7- Visualizar valores totais");
        int opcao = input.nextInt();



        switch (opcao){
            case 1:
                System.out.println("\nDigite o nome do usuário: ");
                String nome = input.next();

                Usuario user = new Usuario(nome);
                UsuarioDAO enviaUser = new UsuarioDAO(con);
                enviaUser.cadastrar(user);

                break;
            case 2:
                System.out.println(userDao.retornaUsuario("Deivid"));
                break;
            case 3:
                lancaRenda(userDao.retornaUsuario("Deivid"));
                break;
        }
        con.close();
    }

    private static void lancaRenda(Usuario user) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja lançar uma renda fixa?");
        String tipo = input.next();
        if(tipo.equalsIgnoreCase("s")){
            lancaRendaFixa();
        }else{
            lancaRendaVariavel();
        }
        /*
        Lancamento renda;

        System.out.println("Digite a descrição dessa renda: ");
        String desc = input.next();

        System.out.println("Digite o valor: ");
        double valor = input.nextDouble();

        System.out.println("A renda é fixa? s-Sim n-Não");


        System.out.println("Digite o mes inicial da renda: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano inicial da renda: ");
        int ano = input.nextInt();

        */
    }

    private static void lancaRendaFixa(){

    }

    private static void lancaRendaVariavel(){

    }

    private static Date regulaData(int mes, int ano) throws ParseException {

        String valor = "12/"+mes+"/"+ano;

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(valor);
        return data;

    }

}

/*
        Usuario user = new Usuario("Deivid");

        UsuarioDAO envia= new UsuarioDAO(con);

        //envia.visualizarTodos();


        Date dataf =  new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2017");

        Usuario usuario = envia.retornaUsuario("Deivid");

        Lancamento lancamento = new Lancamento(500, "Rancho", "d", dataf, usuario);

        LancamentoDAO enviaLancamento = new LancamentoDAO(con);

        envia.retornaUsuario("teste");
        enviaLancamento.inserirLancamento(lancamento);
*/


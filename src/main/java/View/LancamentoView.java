package View;

import Controller.LancamentoController;
import Models.Classes.Usuario;

import java.text.ParseException;
import java.util.Scanner;

public class LancamentoView {

    Scanner input = new Scanner(System.in);
    LancamentoController lancamento = new LancamentoController();


    public void menuLancamentoRenda(Usuario user) throws ParseException {
        System.out.println("*********Lançamento de Renda*********");
        telaCadastro("r", user);
    }

    public void menuLancamentoDespesa(Usuario user) throws ParseException {
        System.out.println("*********Lançamento de despesa*********");
        telaCadastro("d", user);
    }

    public void telaCadastro(String tipo, Usuario user) throws ParseException {
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

        if(tipoVar.equalsIgnoreCase("f")) {
            lancamento.cadastraFixo(valor, desc, tipo, mes, ano, tipoVar, user);
        }else{
            lancaVariavel(valor, desc, tipo, mes, ano, tipoVar, user);
        }

    }

    public void lancaVariavel(double valor,String desc,String tipo,int mes,int ano, String tipoVar, Usuario user) throws ParseException {
        System.out.println("Digite o tipo de parcela do lançamento:\nP- Parcelada\nA- A vista");
        String tipoParcelas = input.next();

        while((!(tipoParcelas.equalsIgnoreCase("p")))&&(!(tipoParcelas.equalsIgnoreCase("a")))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoParcelas=input.next();
        }

        int parcelas = 1;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.println("Digite a quantidade de parcelas: ");
            parcelas = input.nextInt();
        }

        lancamento.cadastraVariavel(valor, desc, tipo, mes, ano, user, parcelas, tipoParcelas);
    }


    public void menuVisualizaValor(){

    }

}

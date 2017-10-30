package view;

import controller.LancamentoController;
import models.classes.Lancamento;
import models.classes.Usuario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LancamentoView {

    Scanner input = new Scanner(System.in);
    LancamentoController lancamentoController = new LancamentoController();

    public void menuLancamentoRenda(Usuario user) throws ParseException {
        System.out.println("*********Lançamento de Renda*********");
        telaCadastro("r", user);
        System.out.println("Lançamento efetuado com sucesso");
    }

    public void menuLancamentoDespesa(Usuario user) throws ParseException {
        System.out.println("*********Lançamento de despesa*********");
        telaCadastro("d", user);
        System.out.println("Lançamento efetuado com sucesso");
    }

    private void telaCadastro(String tipo, Usuario user) throws ParseException {
        System.out.print("Deseja lançar qual tipo?\nF - Fixa\nV - Variável\nDigite a opção: ");
        String tipoVar = input.next();

        while(!(tipoVar.equalsIgnoreCase("v"))&&!(tipoVar.equalsIgnoreCase("f"))){
            System.out.println("Tipo incorreto, digite novamente: ");
            tipoVar=input.next();
        }

        System.out.println("\nDigite a descrição desse lancamento: ");
        String desc = input.next();

        System.out.println("Digite o valor:");
        double valor= input.nextDouble();

        System.out.println("Digite o mês inicial: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano inicial: ");
        int ano = input.nextInt();

        lancamentoController.cadastraValor(valor, desc, tipo, mes, ano, user, tipoVar);

    }

    public void lancaVariavel(double valor,String descricao,String tipo,int mes,int ano, Usuario user) throws ParseException {
        System.out.print("Digite o tipo de parcela do lançamento:\nP- Parcelada\nA- A vista\nDigite a opção: ");
        String tipoParcelas = input.next();

        while((!(tipoParcelas.equalsIgnoreCase("p")))&&(!(tipoParcelas.equalsIgnoreCase("a")))){
            System.out.print("\nTipo incorreto, digite novamente: ");
            tipoParcelas=input.next();
        }

        int parcelas = 1;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.println("\nDigite a quantidade de parcelas: ");
            parcelas = input.nextInt();
        }
        lancamentoController.cadastraValor(valor, descricao, tipo, mes, ano, parcelas, tipoParcelas, user);
    }



    private void visualizaValores(ArrayList<Lancamento> lancamentos){
        for (int i = 0; i < lancamentos.size(); i++) {
            System.out.println(lancamentos.get(i));
        }
        double valor = lancamentoController.retornaTotal(lancamentos);
        System.out.println("\nTotal: " + valor);

    }

    public void visualizaDespesa(Usuario user) throws SQLException {
        System.out.println("***********Despesas***********");
        ArrayList<Lancamento> arrayList = lancamentoController.buscaRendasEDespesas(user,"d");
        visualizaValores(arrayList);
    }

    public void visualizaRenda(Usuario user) throws SQLException {
        System.out.println("***********Rendas***********");
        ArrayList<Lancamento> arrayList = lancamentoController.buscaRendasEDespesas(user,"r");
        visualizaValores(arrayList);
    }


    public void visualizaMes(Usuario user) throws SQLException, ParseException {
        System.out.println("Visualizar um mês\n");
        System.out.println("Digite o mês: ");
        int mes = input.nextInt();
        System.out.println("Digite o ano: ");
        int ano = input.nextInt();

        ArrayList<Lancamento> rendas = lancamentoController.buscaLancamentoMes(user, mes, ano, 1);
        ArrayList<Lancamento> despesas = lancamentoController.buscaLancamentoMes(user, mes, ano, 2);

        mostraDespesasERendas(rendas, despesas);

        double totalRenda = lancamentoController.retornaTotal(rendas);
        double totalDespesa = lancamentoController.retornaTotal(despesas);

        System.out.println("\n**Total no mês**" +
                "\nRenda: " +  totalRenda +
                "\nDespesa: " +  totalDespesa +
                "\nValor Restante: " + lancamentoController.calculaRestante(totalRenda, totalDespesa));

    }

    private void mostraDespesasERendas(ArrayList<Lancamento> rendas, ArrayList<Lancamento> despesas) {
        if (rendas.size()>0){
            System.out.println("\n\t------Rendas------");
        }else{
            System.out.println("\nVocê não possui rendas neste mês");
        }

        for (int i = 0; i < rendas.size(); i++) {
            System.out.println(rendas.get(i));
        }

        if (despesas.size()>0){
            System.out.println("\n\t------Despesas------");
        }else{
            System.out.println("\nVocê não possui despesas neste mês");
        }

        for (int i = 0; i < despesas.size(); i++) {
            System.out.println(despesas.get(i));
        }
    }

}

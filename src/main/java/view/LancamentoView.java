package view;

import controller.LancamentoController;
import models.classes.Lancamento;
import models.classes.Usuario;
import models.services.DataService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class LancamentoView {

    Scanner input = new Scanner(System.in);
    LancamentoController lancamentoController = new LancamentoController(this);

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

        while(mes>12 || mes <1){
            System.out.println("Mês inválido, por favor, digite novamente: ");
            mes = input.nextInt();
        }
        System.out.println("Digite o ano inicial: ");
        int ano = input.nextInt();
        Date data = DataService.regulaData(mes, ano);
        lancamentoController.cadastraValor(valor, desc, tipo, data, user, tipoVar);
    }

    public void menuLancaVariavel(double valor, String descricao, String tipo, Date data, Usuario user) throws ParseException {

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
        lancamentoController.cadastraValor(valor, descricao, tipo, data, parcelas, tipoParcelas, user);
    }

    public void visualizaDespesa(Usuario user) throws SQLException {
        System.out.println("***********Despesas***********");
        String tipo = visualizaTipoLancamento();
        ArrayList<Lancamento> despesas = lancamentoController.buscaRendasEDespesas(user,"d", tipo);
        visualizaValores(despesas);
    }

    public void visualizaRenda(Usuario user) throws SQLException {
        System.out.println("***********Rendas***********");
        String tipo = visualizaTipoLancamento();
        ArrayList<Lancamento> rendas = lancamentoController.buscaRendasEDespesas(user,"r", tipo);
        visualizaValores(rendas);

    }

    private void visualizaValores(ArrayList<Lancamento> lancamentos){
        for (int i = 0; i < lancamentos.size(); i++) {
            System.out.println(lancamentos.get(i));
        }
        double valor = lancamentoController.retornaTotal(lancamentos);
        System.out.print("\033[34;1m");
        System.out.printf("\nTotal: %.2f\n", valor);
        System.out.print("\033[0m");
    }

    private String visualizaTipoLancamento() throws SQLException {
        System.out.println("Seleciona qual tipo deseja visualizar" +
                "\nA - A vista" +
                "\nP - Parceladas" +
                "\nF - Fixas");
        String opcao = input.next();
        while(!opcao.equalsIgnoreCase("a")&&!opcao.equalsIgnoreCase("p")&&!opcao.equalsIgnoreCase("f")){
            System.out.println("Opcao incorreta, digite novamente: ");
            opcao =  input.next();
        }
        return opcao;
    }

    public void visualizaMes(Usuario user) throws SQLException, ParseException {
        System.out.println("Visualizar um mês\n");
        System.out.println("Digite o mês: ");
        int mes = input.nextInt();

        while(mes>12 || mes <1){
            System.out.println("Mês inválido, por favor, digite novamente: ");
            mes = input.nextInt();
        }

        System.out.println("Digite o ano: ");
        int ano = input.nextInt();

        ArrayList<Lancamento> rendas = lancamentoController.buscaLancamentoMes(user, mes, ano, 1);
        ArrayList<Lancamento> despesas = lancamentoController.buscaLancamentoMes(user, mes, ano, 2);

        mostraDespesasERendas(rendas, despesas);

        double totalRenda = lancamentoController.retornaTotal(rendas);
        double totalDespesa = lancamentoController.retornaTotal(despesas);

        System.out.println("\n**Total no mês**\033[0m");
        System.out.print("\033[34;1m");
        System.out.printf("\nRenda total: %.2f", totalRenda);
        System.out.print("\033[0m");
        System.out.print("\033[31;1m");
        System.out.printf("\nDespesa total: %.2f", totalDespesa);
        System.out.print("\033[0m");
        System.out.println("\033[32;1m");
        System.out.printf("\nValor restante no mês: %.2f", lancamentoController.calculaRestante(totalRenda, totalDespesa));
        System.out.print("\033[0m");
        System.out.println("\n");
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

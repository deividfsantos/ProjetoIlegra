package view;

import controller.LancamentoController;
import models.classes.Lancamento;
import models.classes.Usuario;
import models.services.DataService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LancamentoView {

    private LancamentoController lancamentoController = new LancamentoController();
    Scanner input = new Scanner(System.in);

    public void menuLancamentoRenda(Usuario user) throws ParseException{
        System.out.println("*********Lançamento de Renda*********");
        try {
            telaCadastro("r", user);
            System.out.println("Lançamento efetuado com sucesso");
        }catch (SQLException s){
            System.out.println("Erro ao efetuar lançamento");
        }
    }

    public void menuLancamentoDespesa(Usuario user) throws ParseException{
        System.out.println("*********Lançamento de despesa*********");
        try{
            telaCadastro("d", user);
            System.out.println("Lançamento efetuado com sucesso");
        }catch (SQLException s){
            System.out.println("Erro ao efetuar lançamento");
        }
    }

    private void telaCadastro(String tipo, Usuario user) throws ParseException, SQLException {
        System.out.print("\nDigite o tipo de parcela do lançamento" +
                "\nF - Fixa" +
                "\nP - Parcelada" +
                "\nA - A vista" +
                "\nDigite a opção: ");
        String tipoParcelas = input.next();

        while(!tipoParcelas.equalsIgnoreCase("p")&&!tipoParcelas.equalsIgnoreCase("a")&&!tipoParcelas.equalsIgnoreCase("f")){
            System.out.print("\nTipo incorreto, digite novamente: ");
            tipoParcelas=input.next();
        }

        System.out.print("\nDigite a descrição desse lancamento: ");
        String desc = input.next();
        System.out.print("\nDigite o valor: ");
        double valor= input.nextDouble();
        System.out.print("Digite o mês inicial: ");
        int mes = input.nextInt();
        while(mes>12 || mes <1){
            System.out.print("Mês inválido, por favor, digite novamente: ");
            mes = input.nextInt();
        }
        System.out.print("Digite o ano inicial: ");
        int ano = input.nextInt();

        Date data = DataService.regulaData(mes, ano);
        int parcelas = 12;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.print("\nDigite a quantidade de parcelas: ");
            parcelas = input.nextInt();
        }else if(tipoParcelas.equalsIgnoreCase("a")){
            parcelas = 1;
        }

        lancamentoController.cadastraValor(valor, desc, tipo, data, parcelas, tipoParcelas, user);
    }

    public void visualizaDespesa(Usuario user) throws SQLException {
        System.out.printf("\033[34;1m\n***********Despesas***********\033[0m");
        String tipo = visualizaTipoLancamento();
        ArrayList<Lancamento> despesas = lancamentoController.buscaRendasEDespesas(user,"d", tipo);
        visualizaValores(despesas);
    }

    public void visualizaRenda(Usuario user) throws SQLException {
        System.out.println("\033[31;1m\n***********Rendas***********\033[0m");
        String tipo = visualizaTipoLancamento();
        ArrayList<Lancamento> rendas = lancamentoController.buscaRendasEDespesas(user,"r", tipo);
        visualizaValores(rendas);
    }

    private String visualizaTipoLancamento() throws SQLException {
        System.out.print("\nSelecione qual tipo deseja visualizar" +
                "\nA - A vista" +
                "\nP - Parceladas" +
                "\nF - Fixas" +
                "\nDigite a opção: ");

        String opcao = input.next();
        while(!opcao.equalsIgnoreCase("a")&&!opcao.equalsIgnoreCase("p")&&!opcao.equalsIgnoreCase("f")){
            System.out.print("Opcao incorreta, digite novamente: ");
            opcao =  input.next();
        }
        System.out.println("\n");
        return opcao;
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

    public void visualizaMes(Usuario user) throws SQLException, ParseException {
        System.out.println("Visualizar um mês\n");
        System.out.print("Digite o mês: ");
        int mes = input.nextInt();

        while(mes>12 || mes <1){
            System.out.print("Mês inválido, por favor, digite novamente: ");
            mes = input.nextInt();
        }
        System.out.print("Digite o ano: ");
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
            System.out.printf("\033[34;1m\n\t------Rendas------\033[0m\n");
        }else{
            System.out.println("\nVocê não possui rendas neste mês");
        }

        for (int i = 0; i < rendas.size(); i++) {
            System.out.println(rendas.get(i));
        }

        if (despesas.size()>0){
            System.out.printf("\033[31;1m\n\t------Despesas------\n\033[0m");
        }else{
            System.out.println("\nVocê não possui despesas neste mês");
        }

        for (int i = 0; i < despesas.size(); i++) {
            System.out.println(despesas.get(i));
        }
    }

}

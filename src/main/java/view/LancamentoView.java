package view;

import controller.LancamentoController;
import models.classes.Lancamento;
import models.classes.Usuario;
import view.Adjustments.VisualAdjustment;
import view.Adjustments.DataAdjustment;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LancamentoView {

    private LancamentoController lancamentoController = new LancamentoController();
    Scanner input = new Scanner(System.in);

    public void menuLancamentoRenda(Usuario user) throws ParseException{
        System.out.print("\033[34;1m*********Lançamento de Renda*********\033[0m");
        try {
            telaCadastro("r", user);
            System.out.println("Lançamento efetuado com sucesso");
        }catch (SQLException s){
            System.out.println("Erro ao efetuar lançamento");
        }
    }

    public void menuLancamentoDespesa(Usuario user) throws ParseException{
        System.out.print("\033[31;1m*********Lançamento de despesa*********\033[0m");
        try{
            telaCadastro("d", user);
            System.out.println("Lançamento efetuado com sucesso");
        }catch (SQLException s){
            System.out.println("Erro ao efetuar lançamento");
        }
    }

    private void telaCadastro(String tipo, Usuario user) throws ParseException, SQLException {
        String tipoParcelas = selecionaTipoLancamento();

        System.out.print("Digite a descrição desse lancamento: ");
        String desc = input.nextLine();
        System.out.print("\nDigite o valor: ");
        double valor= Double.parseDouble(input.nextLine());
        System.out.print("Digite o mês inicial: ");
        int mes = Integer.parseInt(input.nextLine());
        while(mes>12 || mes <1){
            System.out.print("Mês inválido, por favor, digite novamente: ");
            mes = Integer.parseInt(input.nextLine());
        }
        System.out.print("Digite o ano inicial: ");
        int ano = Integer.parseInt(input.nextLine());

        int parcelas = 12;

        if(tipoParcelas.equalsIgnoreCase("p")) {
            System.out.print("\nDigite a quantidade de parcelas: ");
            parcelas = Integer.parseInt(input.nextLine());
        }else if(tipoParcelas.equalsIgnoreCase("a")){
            parcelas = 1;
        }

        Lancamento lancamento = new Lancamento(valor, desc, tipo, DataAdjustment.regulaData(mes, ano), user, parcelas, tipoParcelas);

        lancamentoController.cadastraValor(lancamento);
    }

    public void visualizaTodasDespesas(Usuario user) throws SQLException {
        System.out.printf("\033[31;1m\n***********Despesas***********\033[0m");
        String tipo = selecionaTipoLancamento();
        ArrayList<Lancamento> despesas = lancamentoController.buscaRendasEDespesas(user,"d", tipo);
        visualizaValores(despesas);
    }

    public void visualizaTodasRendas(Usuario user) throws SQLException {
        System.out.print("\033[34;1m\n***********Rendas***********\033[0m");
        String tipo = selecionaTipoLancamento();
        ArrayList<Lancamento> rendas = lancamentoController.buscaRendasEDespesas(user,"r", tipo);
        visualizaValores(rendas);
    }

    private String selecionaTipoLancamento() throws SQLException {
        System.out.print("\n\nSelecione qual tipo deseja" +
                "\nA - A vista" +
                "\nP - Parceladas" +
                "\nF - Fixas" +
                "\nDigite a opção: ");
        String opcao = input.nextLine();
        while(!opcao.equalsIgnoreCase("a")&&!opcao.equalsIgnoreCase("p")&&!opcao.equalsIgnoreCase("f")){
            System.out.print("Opcao incorreta, digite novamente: ");
            opcao =  input.nextLine();
        }
        return opcao;
    }

    private void visualizaValores(ArrayList<Lancamento> lancamentos){
        visualizarGeral(lancamentos);
        double valor = lancamentoController.retornaTotal(lancamentos);
        System.out.printf("\033[33;1m\n\nTotal: %.2f\n\033[0m", valor);
    }

    public void visualizaMes(Usuario user) throws SQLException, ParseException {
        System.out.println("Visualizar um mês\n");
        System.out.print("Digite o mês: ");
        int mes = Integer.parseInt(input.nextLine());

        while(mes>12 || mes <1){
            System.out.print("Mês inválido, por favor, digite novamente: ");
            mes = Integer.parseInt(input.nextLine());
        }
        System.out.print("Digite o ano: ");
        int ano = Integer.parseInt(input.nextLine());
        ArrayList<Lancamento> rendas = lancamentoController.buscaLancamentoMes(user, mes, ano, 1);
        ArrayList<Lancamento> despesas = lancamentoController.buscaLancamentoMes(user, mes, ano, 2);
        mostraDespesasERendas(rendas, despesas);
        double totalRenda = lancamentoController.retornaTotal(rendas);
        double totalDespesa = lancamentoController.retornaTotal(despesas);

        System.out.println("\033[32;1m\n\n**Total no mês**\033[0m");
        System.out.printf("\033[34;1m\nRenda total: %.2f\033[0m", totalRenda);
        System.out.printf("\033[31;1m\nDespesa total: %.2f\033[0m", totalDespesa);
        System.out.printf("\033[32;1m\nValor restante no mês: %.2f\033[0m\n", lancamentoController.calculaRestante(totalRenda, totalDespesa));
    }

    private void mostraDespesasERendas(ArrayList<Lancamento> rendas, ArrayList<Lancamento> despesas) {
        if (rendas.size()>0){
            System.out.printf("\033[34;1m\n\t------Rendas------\033[0m\n");
        }else{
            System.out.println("\nVocê não possui rendas neste mês");
        }

        visualizarGeral(rendas);

        if (despesas.size()>0){
            System.out.printf("\033[31;1m\n\n\t------Despesas------\n\033[0m");
        }else{
            System.out.println("\nVocê não possui despesas neste mês");
        }
        visualizarGeral(despesas);
    }

    private void visualizarGeral(ArrayList<Lancamento> lancamento){

        for (int i = 0; i < lancamento.size(); i++) {
            System.out.print("\nDescricao: " + VisualAdjustment.ajustaPrint(lancamento.get(i).getDescricao(), 25));
            System.out.print("\t\tValor: " + VisualAdjustment.ajustaPrint(VisualAdjustment.ajustaDouble(lancamento.get(i).getValor()),8));
            System.out.print("\t\tTipo: " + VisualAdjustment.converteTipo(lancamento.get(i).getTipo()));
            System.out.print("\t\tTipo das parcelas: " + VisualAdjustment.converteTipoParcelas(lancamento.get(i).getTipoParcelas()));
            if(lancamento.get(i).getTipoParcelas().equalsIgnoreCase("p")) {
                System.out.print("\t\tData: "+ DataAdjustment.regulaData(lancamento.get(i).getData()));
                System.out.print("\t\tParcelas: "+ lancamento.get(i).getParcelas());
            }else if(lancamento.get(i).getTipoParcelas().equalsIgnoreCase("a")){
                System.out.print("\t\tData: "+ DataAdjustment.regulaData(lancamento.get(i).getData()));
            }
        }
    }
}

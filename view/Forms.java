package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import models.Cabelo;
import models.Cronograma;
import models.enums.SaudeDoCabelo;
import models.enums.TipoDeCabelo;
import models.enums.TipoDeTratamento;
import services.Services;


public class Forms {
    private String linhaCabecalho;
    private ArrayList<ArrayList<String>> tabelaView = new ArrayList<>();


    Scanner leitor = new Scanner(System.in);
    Services servicos = new Services();

    public void iniciarTituloDoPrograma() {
        this.setLinhaCabecalho(125);
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        this.mostrarTitulo("FAÇA SEU CRONOGRAMA CAPILAR");
        System.out.println("\n\n\n");
    }

    public void iniciarApresentacao(){
        String tituloApresentacao = "Cronograma capilar, você sabe o que é?";
        System.out.println(centralizarString(tituloApresentacao));
        System.out.println("\n\n");

        String apresentacao = ("    O cronograma capilar é uma rotina de cuidados com os cabelos que intercala três tratamentos principais: hidratação, nutrição e reconstrução. Cada etapa do cronograma capilar oferece uma solução específica para cabelos danificados por fatores como poluição, incidência de raios solares, cloro da água, uso excessivo de ferramentas de calor, procedimentos químicos de coloração ou descoloração, entre outros.");
        System.out.println(centralizarString(apresentacao));
        System.out.println("\n\n");

    }
    public Cabelo inserirDadosDeCabelo() {
        ;
        
        // Escolhe a saude
        int indexSaude = this.inserirSaude(); // apresenta as opções
        SaudeDoCabelo saude =  servicos.escolheSaudeDoCabelo(indexSaude); // verifica e retorna a const escolhida
        
        //Escolhe o tipo de cabelo
        int indexTipoCabelo = inserirTipoDeCabelo();
        TipoDeCabelo tipoDeCabelo = servicos.escolheTipoCabelo(indexTipoCabelo);
        
        return  new Cabelo(saude, tipoDeCabelo);
    }

    public void mostrarCronograma(ArrayList<ArrayList<TipoDeTratamento>> cronograma, String titulo) {
        ArrayList<ArrayList<String>> cronogramaView = this.ajustaCronogramaView(cronograma);
        this.criacaoDeBorda(cronogramaView);
        System.out.println();
        this.mostrarTitulo(titulo);
        for (ArrayList<String> arrayList : cronogramaView) {
            for (String dado : arrayList) {
                System.out.print("| " + dado);
            }
            System.out.println("|");
        }
        System.out.println(linhaCabecalho + "\n");
    }

    public ArrayList<ArrayList<String>> ajustaCronogramaView(ArrayList<ArrayList<TipoDeTratamento>> cronograma) {
        ArrayList<ArrayList<String>> newMatrizFormat = new ArrayList<>();
        for (int i = 0; i < cronograma.size(); i++) {
            ArrayList<String> linha = new ArrayList<>();
            linha.add(formatedString("SEMANA " + (i+1)));
            for (int j = 0; j < cronograma.get(i).size(); j++) {
                String dado = cronograma.get(i).get(j).getNome();
                linha.add(formatedString(dado));
            }
            newMatrizFormat.add(linha);
        }
        return newMatrizFormat;
    }

    private void criacaoDeBorda(ArrayList<ArrayList<String>> cronograma) {

        int totalEspaco = 0;
        for (int i = 0; i < cronograma.get(0).size(); i++) {
            totalEspaco += (cronograma.get(0).get(i).length() + 2); //total = tamanho do cabeçalho + divisorias (|  |)
        }
        totalEspaco++; // ++ ultima divisoria |
        this.setLinhaCabecalho(totalEspaco);
    }


    private int inserirSaude() {
        System.out.println("\nInforme a saúde do seu cabelo: \n");
        System.out.println("[1] SAUDÁVEL\n[2] POUCO DANIFICADO\n[3] MUITO DANIFICADO");
        System.out.print("Sua resposta:");
        int saudeIndex = Integer.parseInt(leitor.nextLine());
        return saudeIndex;
    }

    private int inserirTipoDeCabelo() {
        System.out.println("\nInforme o seu tipo cabelo: \n");
        System.out.println("[1] LISO\n[2] ONDULADO\n[3] CACHEADO\n[4] CRESPO");
        System.out.print("Sua resposta:");
        int tipoCabeloIndex = Integer.parseInt(leitor.nextLine());
        return tipoCabeloIndex;
    }

    private void setLinhaCabecalho(int number) {
        String linha = "";
        for (int i = 0; i < number; i++) {
            linha += "-";
        }
        this.linhaCabecalho = linha;
    }

    private String centralizarString(String string) {
        String stringCentralizada = "";
        for (int i = 0; i < (linhaCabecalho.length()/2 - string.length()/2); i++) {
            stringCentralizada += " ";
        }
        return stringCentralizada + string;
    }

    private String formatedString(String text) {
        return String.format(" %-15.15s ", text);
    }

    private void mostrarTitulo(String titulo) {
        System.out.println(linhaCabecalho);
        System.out.println(this.centralizarString(titulo));
        System.out.println(linhaCabecalho);
    }

}

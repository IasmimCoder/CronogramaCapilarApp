package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import models.enums.SaudeDoCabelo;
import models.enums.TipoDeTratamento;

public class Cronograma {
    private int qtdHidracao;
    private int qtdNutricao;
    private int qtdRestauracao;
    private TreeMap<String, ArrayList<TipoDeTratamento>> cronograma = new TreeMap<>();
    private SaudeDoCabelo saudeDoCabelo;
    public Cronograma() {
    };

    public void iniciarCronogramaDefault() {
        if( saudeDoCabelo.getTipo() == 1) {
            this.defaultHidratacao();
        }
        if( saudeDoCabelo.getTipo() == 2) {
            this.defaultNutricao();
        }
        if( saudeDoCabelo.getTipo() == 3) {
            this.defaultReconstrucao();
        }


        System.out.println(cronograma.get("Semana1"));

    }

    @Override
    public String toString() {
        return "Cronograma [qtdHidracao=" + qtdHidracao + ", qtdNutricao=" + qtdNutricao + ", qtdRestauracao="
                + qtdRestauracao + ", cronograma=" + cronograma + "]";
    }

    private void defaultHidratacao() {
        cronograma.put("Semana1",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana2",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO)));
        cronograma.put("Semana3",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana4",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO)));
    }

    private void defaultNutricao() {
        cronograma.put("Semana1",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana2",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana3",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO)));
        cronograma.put("Semana4",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO)));
    }

    private void defaultReconstrucao() {
        cronograma.put("Semana1",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana2",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO)));
        cronograma.put("Semana3",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)));
        cronograma.put("Semana4",
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO)));
    }

}

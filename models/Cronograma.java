package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import models.enums.TipoDeCabelo;
import models.enums.TipoDeTratamento;

public class Cronograma {
    private Cabelo cabelo;
    private ArrayList<ArrayList<TipoDeTratamento>> cronograma = new ArrayList<>();

    // private SaudeDoCabelo saudeDoCabelo;

    public Cronograma(Cabelo cabelo) {
        this.cabelo = cabelo;
    };

    public void iniciarCronogramaDefault() {

        if (cabelo.getSaudeDoCabelo().getTipo() == 1) {
            this.defaultHidratacao();
        }
        if (cabelo.getSaudeDoCabelo().getTipo() == 2) {
            this.defaultNutricao();
        }
        if (cabelo.getSaudeDoCabelo().getTipo() == 3) {
            this.defaultReconstrucao();
        }
        this.refinarCronograma();
    }

    public Cabelo getCabelo() {
        return cabelo;
    }

    public void setCabelo(Cabelo cabelo) {
        this.cabelo = cabelo;
    }

    public ArrayList<ArrayList<TipoDeTratamento>> getCronograma() {
        return cronograma;
    }

    public void setCronograma(ArrayList<ArrayList<TipoDeTratamento>> cronograma) {
        this.cronograma = cronograma;
    }

    @Override
    public String toString() {
        return "Cronograma [ cronograma=" + cronograma + "]";
    }

    private void defaultHidratacao() {
        cronograma.addAll(Arrays.asList(
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO))));
    }

    private void defaultNutricao() {
        cronograma.addAll(Arrays.asList(
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO))));
    }

    private void defaultReconstrucao() {
        cronograma.addAll(Arrays.asList(
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO,
                        TipoDeTratamento.HIDRATACAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.NUTRICAO)),
                new ArrayList<TipoDeTratamento>(Arrays.asList(
                        TipoDeTratamento.HIDRATACAO,
                        TipoDeTratamento.RECONSTRUCAO,
                        TipoDeTratamento.HIDRATACAO))));
    }

    /*Caso o cabelo do usuário seja cacheado ou crespo, este terá uma maior necessidade de nutrições.
     * Assim, a partir deste método, identificamos se o usuario tem esta necessidade ou não.
     * Caso sim, substituimos uma das hidratações e por uma nutrição com o método porMaisUmaNutricao().
     * Entretanto, esta substituição não deve ser feita aleatoriamente, pois comprometeria a qualidade
     * do cronograma. Desta forma, é chamado o método findSemanaParaAlteracao().*/
    private void refinarCronograma() {
        if (this.cabelo.getTipoDeCabelo() == TipoDeCabelo.CACHEADO ||
                this.cabelo.getTipoDeCabelo() == TipoDeCabelo.CRESPO) {
            int semanaIndex = this.findSemanaParaAlteracao();
            this.porMaisUmaNutricao(semanaIndex);
        }
    }

    /*Identifica qual semana possui duas hidratações. Se houver mais de uma neste padrão, retorna a primeira.
     * Caso não haja, retorna -1. 
     */
    private int findSemanaParaAlteracao() {
        int semanaAlteradaIndex = 0;
        for (int i = 0; i < this.cronograma.size(); i++) {
            int hidratacaoPorSemana = 0;
            for (int j = 0; j < this.cronograma.get(i).size(); j++) {
                if (this.cronograma.get(i).get(j) == TipoDeTratamento.HIDRATACAO) {
                    hidratacaoPorSemana++;
                }
            }
            if (hidratacaoPorSemana == 2) {
                return semanaAlteradaIndex = i;
            }
        }
        return -1;
    }

    private void porMaisUmaNutricao(int semanaIndex) {
        

        // Limpar a semana para redefinir
        this.cronograma.get(semanaIndex).clear();

        // Definição de nutrição para cachos
        this.cronograma.get(semanaIndex).addAll(Arrays.asList(
                TipoDeTratamento.NUTRICAO,
                TipoDeTratamento.HIDRATACAO,
                TipoDeTratamento.NUTRICAO));

        verificarTratamentos(semanaIndex);
    }

    /*Verifica se há algum tratamento sucessivamente iguais entre a semana escolhida 
    para alteração e sua antecessora ou sucessora.
    * Caso sim, na semana antessora o último tratamento é invertido com o segundo. 
    * Na semana sucessora, o primeiro tratamento é invertido com o segundo.*/
    private void verificarTratamentos(int semanaIndex){
        // INDEX
        int primeiroIndex = 0;
        int ultimoIndex = 2;

        //altera a semana anterior
        if (semanaIndex > 0) {
            if (this.cronograma.get(semanaIndex).get(primeiroIndex) == this.cronograma
                    .get(semanaIndex - 1).get(ultimoIndex)) {
                int semana = semanaIndex - 1;
                Collections.swap(this.cronograma.get(semana), 2, 1);
            }
        }

        // altera a próxima semana
        if (semanaIndex < 3) {
            if (this.cronograma.get(semanaIndex).get(ultimoIndex) == this.cronograma
                    .get(semanaIndex + 1).get(primeiroIndex)) {
                int semana = semanaIndex + 1;
                Collections.swap(this.cronograma.get(semana), 0, 1);
            }
        }
    }
}

package models;

import models.enums.*;;

public class Cabelo {
    private SaudeDoCabelo saudeDoCabelo;
    private TipoDeCabelo tipoDeCabelo;
    private boolean comQuimica;
    
    private EspessuraDosFios espessuraDosFios;

    
    

    public Cabelo() {};

   
    public TipoDeCabelo getTipoDeCabelo() {
        return tipoDeCabelo;
    }
    public void setTipoDeCabelo(TipoDeCabelo tipoDeCabelo) {
        this.tipoDeCabelo = tipoDeCabelo;
    }
    public SaudeDoCabelo getSaudeDoCabelo() {
        return saudeDoCabelo;
    }
    public void setSaudeDoCabelo(SaudeDoCabelo saudeDoCabelo) {
        this.saudeDoCabelo = saudeDoCabelo;
    }
    public EspessuraDosFios getEspessuraDosFios() {
        return espessuraDosFios;
    }
    public void setEspessuraDosFios(EspessuraDosFios espessuraDosFios) {
        this.espessuraDosFios = espessuraDosFios;
    }
    public boolean isComQuimica() {
        return comQuimica;
    }
    public void setComQuimica(boolean comQuimica) {
        this.comQuimica = comQuimica;
    }
    public String getUltimaHidracao() {
        return ultimaHidracao;
    }
    public void setUltimaHidracao(String ultimaHidracao) {
        this.ultimaHidracao = ultimaHidracao;
    }
    public String getUltimaNutricao() {
        return ultimaNutricao;
    }
    public void setUltimaNutricao(String ultimaNutricao) {
        this.ultimaNutricao = ultimaNutricao;
    }
    public String getUltimaRestauracao() {
        return ultimaRestauracao;
    }
    public void setUltimaRestauracao(String ultimaRestauracao) {
        this.ultimaRestauracao = ultimaRestauracao;
    }
}

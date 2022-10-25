package models;

import models.enums.*;;

public class Cabelo {
    private SaudeDoCabelo saudeDoCabelo;
    private TipoDeCabelo tipoDeCabelo;


    
    

   public Cabelo(){};
   
    public Cabelo(SaudeDoCabelo saudeDoCabelo, TipoDeCabelo tipoDeCabelo) {
        this.saudeDoCabelo = saudeDoCabelo;
        this.tipoDeCabelo = tipoDeCabelo;

    }
    
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
}

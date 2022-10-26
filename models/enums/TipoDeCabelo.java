package models.enums;

public enum TipoDeCabelo {
    LISO(1, "Liso"),
    ONDULADO(2, "Ondulado"),
    CACHEADO(3, "Cacheado"),
    CRESPO(4, "Crespo");

    private int tipo;
    private String nome;

    private TipoDeCabelo(int tipo, String nome){
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getTipo(){
        return tipo;
    }

    public String getNome(){
        return nome;
    }
}

package models.enums;

public enum SaudeDoCabelo {
    SAUDAVEL(1, "Saudável"),
    POUCO_DANIFICADO(2, "Pouco Danificado"),
    MUITO_DANIFICADO(3, "Muito Danificado");

    private int tipo;
    private String nome;

    SaudeDoCabelo(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}

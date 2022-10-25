package models.enums;

public enum TipoDeTratamento {
    HIDRATACAO(1, "Hidratação"),
    NUTRICAO(2, "Nutrição"),
    RECONSTRUCAO(3, "Reconstrução");

    private int tipo;
    private String nome;

    private TipoDeTratamento(int tipo, String nome) {
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

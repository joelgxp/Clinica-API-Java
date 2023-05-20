package br.com.jvsmed.api.cnh;

public enum Categoria {
    A("A"), B("B"), C("C"), D("D"), E("E"), AB("AB"), AC("AC"), AD("AD"), AE("AE");

    private String categoria;

    Categoria() {}

    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}

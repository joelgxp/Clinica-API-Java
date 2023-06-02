package br.com.jvsmed.api.enums;

public enum ECategoria {
    A("A"), B("B"), C("C"), D("D"), E("E"), AB("AB"), AC("AC"), AD("AD"), AE("AE");

    private String categoria;

    ECategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

}
package br.com.rsdconsultoria.contabilidade.core.aggregates;

public class Dinheiro {
    private long valor;
    private String moeda;

    public long getValor() {
        return valor;
    }

    public Dinheiro setValor(long valor) {
        this.valor = valor;
        return this;
    }

    public String getMoeda() {
        return moeda;
    }

    public Dinheiro setMoeda(String moeda) {
        this.moeda = moeda;
        return this;
    }
}

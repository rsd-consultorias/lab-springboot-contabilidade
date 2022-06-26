package br.com.rsdconsultoria.contabilidade.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DinheiroVM {
    private long valor;
    @Column(length = 3)
    private String moeda;

    public long getValor() {
        return valor;
    }

    public DinheiroVM setValor(long valor) {
        this.valor = valor;
        return this;
    }

    public String getMoeda() {
        return moeda;
    }

    public DinheiroVM setMoeda(String moeda) {
        this.moeda = moeda;
        return this;
    }
}

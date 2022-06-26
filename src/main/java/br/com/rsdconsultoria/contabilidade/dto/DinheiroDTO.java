package br.com.rsdconsultoria.contabilidade.dto;

import br.com.rsdconsultoria.contabilidade.models.DinheiroVM;

public class DinheiroDTO {
    private long valor;
    private String moeda;

    public long getValor() {
        return valor;
    }

    public DinheiroDTO setValor(long valor) {
        this.valor = valor;
        return this;
    }

    public String getMoeda() {
        return moeda;
    }

    public DinheiroDTO setMoeda(String moeda) {
        this.moeda = moeda;
        return this;
    }

    public static DinheiroDTO of(DinheiroVM dinheiro) {
        return new DinheiroDTO().setMoeda(dinheiro.getMoeda()).setValor(dinheiro.getValor());
    }

    public DinheiroVM toDinheiroVM(){
        return new DinheiroVM().setMoeda(this.getMoeda()).setValor(this.getValor());
    }
}

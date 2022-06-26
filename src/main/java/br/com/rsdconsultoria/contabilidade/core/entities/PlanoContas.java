/*MIT License

Copyright (c) 2022 Rafael Dias

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package br.com.rsdconsultoria.contabilidade.core.entities;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import br.com.rsdconsultoria.contabilidade.core.aggregates.ContaContabil;

public final class PlanoContas {

    private UUID id;
    private String versao;
    private String descricao;
    private String mascaraContas;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;
    private List<ContaContabil> contas;

    public UUID getId() {
        return id;
    }

    public PlanoContas setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public PlanoContas setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public PlanoContas setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getMascaraContas() {
        return mascaraContas;
    }

    public PlanoContas setMascaraContas(String mascaraContas) {
        this.mascaraContas = mascaraContas;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public PlanoContas setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public PlanoContas setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public List<ContaContabil> getContas() {
        return contas;
    }

    public PlanoContas setContas(List<ContaContabil> contas) {
        this.contas = contas;
        return this;
    }
}

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

package br.com.rsdconsultoria.rsdcontabilidade.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.rsdconsultoria.rsdcontabilidade.models.ContaContabilVM;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class ContaContabilDTO {
    private UUID id;
    private UUID planoContasId;
    private String codigo;
    private String descricao;
    private char natureza;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;

    public UUID getId() {
        return id;
    }

    public ContaContabilDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getPlanoContasId() {
        return planoContasId;
    }

    public ContaContabilDTO setPlanoContasId(UUID planoContasId) {
        this.planoContasId = planoContasId;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public ContaContabilDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaContabilDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public char getNatureza() {
        return natureza;
    }

    public ContaContabilDTO setNatureza(char natureza) {
        this.natureza = natureza;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public ContaContabilDTO setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public ContaContabilDTO setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public static ContaContabilDTO of(ContaContabilVM contaContabilVM) {
        return new ContaContabilDTO().setPlanoContasId(contaContabilVM.getPlanoContasId())
                .setCodigo(contaContabilVM.getCodigo()).setDataFim(contaContabilVM.getDataFim())
                .setDataInicio(contaContabilVM.getDataInicio()).setDescricao(contaContabilVM.getDescricao())
                .setId(contaContabilVM.getId()).setNatureza(contaContabilVM.getNatureza());
    }

    public ContaContabilVM toContaContabilVM() {
        return new ContaContabilVM().setPlanoContasId(this.getPlanoContasId()).setCodigo(this.getCodigo())
                .setDataFim(this.getDataFim()).setDataInicio(this.getDataInicio()).setDescricao(this.getDescricao())
                .setId(this.getId()).setNatureza(this.getNatureza());
    }
}

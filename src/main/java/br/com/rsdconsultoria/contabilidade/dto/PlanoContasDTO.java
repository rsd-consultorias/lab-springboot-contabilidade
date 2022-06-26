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

package br.com.rsdconsultoria.contabilidade.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;
import br.com.rsdconsultoria.contabilidade.models.PlanoContasVM;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public final class PlanoContasDTO {

    private UUID id;
    private String versao;
    private String descricao;
    private String mascaraContas;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;
    private List<ContaContabilDTO> contas;

    public UUID getId() {
        return id;
    }

    public PlanoContasDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public PlanoContasDTO setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public PlanoContasDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getMascaraContas() {
        return mascaraContas;
    }

    public PlanoContasDTO setMascaraContas(String mascaraContas) {
        this.mascaraContas = mascaraContas;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public PlanoContasDTO setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public PlanoContasDTO setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public List<ContaContabilDTO> getContas() {
        return contas;
    }

    public PlanoContasDTO setContas(List<ContaContabilDTO> contas) {
        this.contas = contas;
        return this;
    }

    public PlanoContasVM toPlanoContasVM() {
        return new PlanoContasVM().setDataFim(this.getDataFim()).setDataInicio(this.getDataInicio())
                .setDescricao(this.getDescricao()).setId(this.getId()).setVersao(this.getVersao())
                .setMascaraContas(this.getMascaraContas());
    }

    public static PlanoContasDTO of(PlanoContasVM planoContasVM) {
        var planoContas = new PlanoContasDTO().setDataFim(planoContasVM.getDataFim())
                .setDataInicio(planoContasVM.getDataInicio()).setDescricao(planoContasVM.getDescricao())
                .setMascaraContas(planoContasVM.getMascaraContas()).setId(planoContasVM.getId())
                .setVersao(planoContasVM.getVersao());

        if (planoContasVM.getContas() != null) {
            var contas = new ArrayList<ContaContabilDTO>();
            planoContasVM.getContas().stream().forEach(a -> contas.add(ContaContabilDTO.of(a)));

            planoContas.setContas(contas);
        }

        return planoContas;
    }

    public static PlanoContasDTO ofWithNoChilds(PlanoContasVM planoContasVM) {
        var planoContas = new PlanoContasDTO().setDataFim(planoContasVM.getDataFim())
                .setDataInicio(planoContasVM.getDataInicio()).setDescricao(planoContasVM.getDescricao())
                .setMascaraContas(planoContasVM.getMascaraContas()).setId(planoContasVM.getId())
                .setVersao(planoContasVM.getVersao());

        return planoContas;
    }
}

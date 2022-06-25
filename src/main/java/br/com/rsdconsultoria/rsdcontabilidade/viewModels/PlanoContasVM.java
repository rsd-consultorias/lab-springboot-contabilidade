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

package br.com.rsdconsultoria.rsdcontabilidade.viewModels;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabPlanoContas")
public class PlanoContasVM extends AuditoriaDadosBase {
    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID Id;

    @Column(unique = true, nullable = false)
    private String versao;
    
    private String Descricao;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;

    public UUID getId() {
        return Id;
    }

    public PlanoContasVM setId(UUID id) {
        this.Id = id;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public PlanoContasVM setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public String getDescricao() {
        return Descricao;
    }

    public PlanoContasVM setDescricao(String descricao) {
        this.Descricao = descricao;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public PlanoContasVM setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public PlanoContasVM setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }
}

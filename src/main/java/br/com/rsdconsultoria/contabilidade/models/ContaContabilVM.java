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

package br.com.rsdconsultoria.contabilidade.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domContasContabeis")
public class ContaContabilVM extends AuditoriaDadosBase {
    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(length = 16, name = "planocontas_id", nullable = false)
    private UUID planoContasId;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, length = 1)
    private char natureza;

    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;

    public UUID getId() {
        return id;
    }

    public ContaContabilVM setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getPlanoContasId() {
        return planoContasId;
    }

    public ContaContabilVM setPlanoContasId(UUID planoContasId) {
        this.planoContasId = planoContasId;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public ContaContabilVM setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaContabilVM setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public char getNatureza() {
        return natureza;
    }

    public ContaContabilVM setNatureza(char natureza) {
        this.natureza = natureza;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public ContaContabilVM setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public ContaContabilVM setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }
}

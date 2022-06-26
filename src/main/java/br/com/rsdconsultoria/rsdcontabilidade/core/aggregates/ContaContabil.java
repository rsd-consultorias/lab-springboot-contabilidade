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

package br.com.rsdconsultoria.rsdcontabilidade.core.aggregates;

import java.time.OffsetDateTime;
import java.util.UUID;

public class ContaContabil {
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

    public ContaContabil setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getPlanoContasId() {
        return planoContasId;
    }

    public ContaContabil setPlanoContasId(UUID planoContasId) {
        this.planoContasId = planoContasId;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public ContaContabil setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ContaContabil setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public char getNatureza() {
        return natureza;
    }

    public ContaContabil setNatureza(char natureza) {
        this.natureza = natureza;
        return this;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public ContaContabil setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public ContaContabil setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
        return this;
    }
}

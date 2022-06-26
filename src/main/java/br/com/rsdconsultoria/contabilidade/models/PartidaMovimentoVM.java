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

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trxPartidasMovimentos")
public class PartidaMovimentoVM extends AuditoriaDadosBase {
    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(length = 16, name = "movimento_id", nullable = false)
    private UUID movimentoId;

    @Column(length = 16)
    private UUID centroCustosId;

    private int ano;
    private int mes;
    private int dia;
    private char natureza;
    private DinheiroVM valor;

    public UUID getId() {
        return id;
    }

    public PartidaMovimentoVM setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getMovimentoId() {
        return movimentoId;
    }

    public PartidaMovimentoVM setMovimentoId(UUID movimentoId) {
        this.movimentoId = movimentoId;
        return this;
    }
}

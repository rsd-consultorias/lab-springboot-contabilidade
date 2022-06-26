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
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Table(name = "trxTransacoes")
public class TransacaoVM extends AuditoriaDadosBase {
    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(length = 16, name = "empresa_id", nullable = false)
    private UUID empresaId;

    @Column(length = 20, nullable = false)
    private String codigo;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "transacao_id")
    private List<EventoVM> eventos;
    
    @Column(nullable = false)
    private OffsetDateTime data;

    @Column(length = 20)
    private String status;

    public UUID getId() {
        return id;
    }

    public TransacaoVM setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getEmpresaId() {
        return empresaId;
    }

    public TransacaoVM setEmpresaId(UUID empresaId) {
        this.empresaId = empresaId;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public TransacaoVM setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public List<EventoVM> getEventos() {
        return eventos;
    }

    public TransacaoVM setEventos(List<EventoVM> eventos) {
        this.eventos = eventos;
        return this;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public TransacaoVM setData(OffsetDateTime data) {
        this.data = data;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TransacaoVM setStatus(String status) {
        this.status = status;
        return this;
    }
}

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

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trxMovimentos")
public class MovimentoVM extends AuditoriaDadosBase {
    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    @Column(length = 16, name = "empresa_id", nullable = false)
    private UUID empresaId;

    @Column(length = 200)
    private String historico;
    
    @Column(length = 200)
    private String complemento;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movimento_id")
    private List<PartidaMovimentoVM> partidas;

    public UUID getId() {
        return id;
    }

    public MovimentoVM setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getEmpresaId() {
        return empresaId;
    }

    public MovimentoVM setEmpresaId(UUID empresaId) {
        this.empresaId = empresaId;
        return this;
    }

    public List<PartidaMovimentoVM> getPartidas() {
        return partidas;
    }

    public MovimentoVM setPartidas(List<PartidaMovimentoVM> partidas) {
        this.partidas = partidas;
        return this;
    }
}

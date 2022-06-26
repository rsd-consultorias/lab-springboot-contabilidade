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

import br.com.rsdconsultoria.contabilidade.core.aggregates.Evento;

public final class Transacao {
    private UUID id;
    private String codigo;
    private List<Evento> eventos;
    private OffsetDateTime data;
    private String status;

    public UUID getId() {
        return id;
    }

    public Transacao setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Transacao setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Transacao setEventos(List<Evento> eventos) {
        this.eventos = eventos;
        return this;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public Transacao setData(OffsetDateTime data) {
        this.data = data;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Transacao setStatus(String status) {
        this.status = status;
        return this;
    }
}

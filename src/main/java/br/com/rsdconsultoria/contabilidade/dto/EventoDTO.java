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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.rsdconsultoria.contabilidade.models.EventoVM;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public final class EventoDTO {
    private String codigo;
    private long valor;
    private char natureza;

    public String getCodigo() {
        return codigo;
    }

    public EventoDTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public long getValor() {
        return valor;
    }

    public EventoDTO setValor(long valor) {
        this.valor = valor;
        return this;
    }

    public char getNatureza() {
        return natureza;
    }

    public EventoDTO setNatureza(char natureza) {
        this.natureza = natureza;
        return this;
    }

    public EventoVM toEventoVM() {
        return new EventoVM().setCodigo(this.getCodigo()).setNatureza(this.getNatureza()).setValor(this.getValor());
    }

    public static EventoDTO of(EventoVM eventoVM) {
        return new EventoDTO().setCodigo(eventoVM.getCodigo()).setNatureza(eventoVM.getNatureza())
                .setValor(eventoVM.getValor());
    }
}

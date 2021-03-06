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

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class APIResponse<T> {
    private Boolean sucesso;
    private String mensagem;
    private T body;

    public Boolean getSucesso() {
        return sucesso;
    }

    public APIResponse<T> setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public APIResponse<T> setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public T getBody() {
        return body;
    }

    public APIResponse<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public APIResponse<T> sucesso() {
        return setSucesso(true);
    }

    public APIResponse<T> falha() {
        return setSucesso(false);
    }
}

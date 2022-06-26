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

package br.com.rsdconsultoria.rsdcontabilidade.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.rsdcontabilidade.dto.APIResponse;
import br.com.rsdconsultoria.rsdcontabilidade.dto.TransacaoDTO;
import br.com.rsdconsultoria.rsdcontabilidade.infra.repositories.TransacaoRepository;
import br.com.rsdconsultoria.rsdcontabilidade.utils.Constants;

@RestController
@RequestMapping("/api/${br.com.rsdconsultoria.api.version}/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @PutMapping
    public APIResponse<TransacaoDTO> incluir(@RequestBody TransacaoDTO transacao) {
        transacao.setStatus(Constants.STATUS_FILA_ENFILEIRADA);
        transacao = TransacaoDTO.ofWithNoChilds(transacaoRepository.save(transacao.toTransacaoVM()));
        return new APIResponse<TransacaoDTO>().sucesso().setBody(transacao);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public APIResponse<TransacaoDTO> buscarPorId(@PathVariable UUID id) {
        var msg = new APIResponse<TransacaoDTO>();
        TransacaoDTO transacao = null;
        var transacaoVM = transacaoRepository.findById(id);
        if (transacaoVM.isPresent()){
            transacao = TransacaoDTO.of(transacaoVM.get());
        }

        return msg.setBody(transacao).sucesso();
    }
}

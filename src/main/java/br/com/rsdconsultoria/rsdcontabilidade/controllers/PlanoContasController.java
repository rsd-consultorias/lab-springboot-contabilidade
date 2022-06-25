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

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.rsdcontabilidade.infra.repositories.PlanoContasRepository;
import br.com.rsdconsultoria.rsdcontabilidade.viewModels.APIMensagemResponse;
import br.com.rsdconsultoria.rsdcontabilidade.viewModels.PlanoContasVM;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/${br.com.rsdconsultoria.api.version}/plano-contas")
public class PlanoContasController {
    @Autowired
    private PlanoContasRepository planoContasRepository;

    // Plano de Contas
    @GetMapping
    @Operation(summary = "Listar todos planos de contas cadastrados")
    public APIMensagemResponse<List<PlanoContasVM>> listarPlanosContas() {
        return new APIMensagemResponse<List<PlanoContasVM>>().setSucesso(true).setBody(planoContasRepository.findAll());
    }

    @GetMapping("/{id}")
    public APIMensagemResponse<PlanoContasVM> buscarPlanoContas(@PathVariable UUID id) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    @PutMapping
    public APIMensagemResponse<PlanoContasVM> incluirPlanoContas(@RequestBody PlanoContasVM planoContas) {
        var msg = new APIMensagemResponse<PlanoContasVM>();
        try {
            var novoPlanoContas = planoContasRepository.saveAndFlush(planoContas);
            return msg.setSucesso(true).setMensagem("Plano de contas cadastrado com sucesso.").setBody(novoPlanoContas);
        } catch (Exception e) {
            return msg.setSucesso(false)
                    .setMensagem("Erro ao cadastrar o plano de contas: entre em contato com o suporte.");
        }
    }

    @PostMapping("/{id}")
    public APIMensagemResponse<PlanoContasVM> alterarPlanoContas(@PathVariable UUID id,
            @RequestBody PlanoContasVM planoContas) {
        var msg = new APIMensagemResponse<PlanoContasVM>();
        try {
            var planoContasExistente = planoContasRepository.findById(id);
            if (planoContasExistente.isPresent()) {
                var novoPlanoContas = planoContasRepository.saveAndFlush(planoContasExistente.get()
                        .setDataInicio(planoContas.getDataInicio()).setDataFim(planoContas.getDataFim())
                        .setDescricao(planoContas.getDescricao()).setVersao(planoContas.getVersao()));
                return msg.setSucesso(true).setMensagem("Plano de contas alterado com sucesso.")
                        .setBody(novoPlanoContas);
            } else {
                return msg.setSucesso(false).setMensagem("Plano de contas não encontrado.");
            }
        } catch (Exception e) {
            return msg.setSucesso(false)
                    .setMensagem("Erro ao cadastrar o plano de contas: entre em contato com o suporte.");
        }
    }

    @DeleteMapping("/{id}")
    public APIMensagemResponse<PlanoContasVM> excluirPlanoContas(@PathVariable UUID id) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    // Contas do PlanoContas
    @GetMapping("/{planoContasId}/contas")
    public APIMensagemResponse<PlanoContasVM> listarContas(@PathVariable UUID planoContasId) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    @GetMapping("/{planoContasId}/contas/{id}")
    public APIMensagemResponse<PlanoContasVM> listarContas(@PathVariable UUID planoContasId, @PathVariable UUID id) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    @PutMapping("/{planoContasId}/contas")
    public APIMensagemResponse<PlanoContasVM> incluirContas(@PathVariable UUID planoContasId,
            @RequestBody PlanoContasVM contas) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    @PostMapping("/{planoContasId}/contas")
    public APIMensagemResponse<PlanoContasVM> alterarContas(@PathVariable UUID planoContasId,
            @RequestBody PlanoContasVM contas) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }

    @DeleteMapping("/{planoContasId}/contas/{id}")
    public APIMensagemResponse<PlanoContasVM> excluirContas(@PathVariable UUID planoContasId, @PathVariable UUID id) {
        return new APIMensagemResponse<PlanoContasVM>().setSucesso(true).setMensagem("Teste OK!");
    }
}

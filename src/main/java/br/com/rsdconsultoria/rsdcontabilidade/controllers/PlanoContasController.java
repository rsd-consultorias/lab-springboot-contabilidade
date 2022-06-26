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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.rsdcontabilidade.dto.APIResponse;
import br.com.rsdconsultoria.rsdcontabilidade.dto.ContaContabilDTO;
import br.com.rsdconsultoria.rsdcontabilidade.dto.PlanoContasDTO;
import br.com.rsdconsultoria.rsdcontabilidade.infra.repositories.ContaContabilRepository;
import br.com.rsdconsultoria.rsdcontabilidade.infra.repositories.PlanoContasRepository;
import br.com.rsdconsultoria.rsdcontabilidade.models.ContaContabilVM;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/${br.com.rsdconsultoria.api.version}/plano-contas")
public class PlanoContasController {
    @Autowired
    private PlanoContasRepository planoContasRepository;

    @Autowired
    private ContaContabilRepository contaContabilRepository;

    // Plano de Contas
    @GetMapping
    @Operation(summary = "Listar todos planos de contas cadastrados")
    // @Transactional(readOnly = true)
    public APIResponse<List<PlanoContasDTO>> listarPlanosContas() {
        var planosContas = new ArrayList<PlanoContasDTO>();
        var planoContasVM = planoContasRepository.findAll();
        planoContasVM.forEach(a -> planosContas.add(PlanoContasDTO.ofWithNoChilds(a)));
        return new APIResponse<List<PlanoContasDTO>>().sucesso().setBody(planosContas);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public APIResponse<PlanoContasDTO> buscarPlanoContas(@PathVariable UUID id) {
        return new APIResponse<PlanoContasDTO>().sucesso()
                .setBody(PlanoContasDTO.of(planoContasRepository.findById(id).get()));
    }

    @PutMapping
    public APIResponse<PlanoContasDTO> incluirPlanoContas(@RequestBody PlanoContasDTO planoContas) {
        var msg = new APIResponse<PlanoContasDTO>();
        try {
            var novoPlanoContas = planoContasRepository.saveAndFlush(planoContas.toPlanoContasVM());
            return msg.sucesso().setMensagem("Plano de contas cadastrado com sucesso.")
                    .setBody(PlanoContasDTO.ofWithNoChilds(novoPlanoContas));
        } catch (Exception e) {
            return msg.falha().setMensagem("Erro ao cadastrar o plano de contas: entre em contato com o suporte.");
        }
    }

    @PostMapping("/{id}")
    public APIResponse<PlanoContasDTO> alterarPlanoContas(@PathVariable UUID id,
            @RequestBody PlanoContasDTO planoContas) {
        var msg = new APIResponse<PlanoContasDTO>();
        try {
            var planoContasExistente = planoContasRepository.findById(id);
            if (planoContasExistente.isPresent()) {
                var novoPlanoContas = planoContasRepository
                        .saveAndFlush(planoContasExistente.get().setMascaraContas(planoContas.getMascaraContas())
                                .setDataInicio(planoContas.getDataInicio()).setDataFim(planoContas.getDataFim())
                                .setDescricao(planoContas.getDescricao()).setVersao(planoContas.getVersao()));
                return msg.setSucesso(true).setMensagem("Plano de contas alterado com sucesso.")
                        .setBody(PlanoContasDTO.ofWithNoChilds(novoPlanoContas));
            } else {
                return msg.setSucesso(false).setMensagem("Plano de contas não encontrado.");
            }
        } catch (Exception e) {
            return msg.setSucesso(false)
                    .setMensagem("Erro ao cadastrar o plano de contas: entre em contato com o suporte.");
        }
    }

    @DeleteMapping("/{id}")
    public APIResponse<PlanoContasDTO> excluirPlanoContas(@PathVariable UUID id) {
        var a = contaContabilRepository.findAll(Example.of(new ContaContabilVM().setPlanoContasId(id)));
        contaContabilRepository.deleteAll(a);
        planoContasRepository.deleteById(id);
        contaContabilRepository.flush();
        planoContasRepository.flush();
        return new APIResponse<PlanoContasDTO>().setSucesso(!planoContasRepository.existsById(id))
                .setMensagem("Teste OK!");
    }

    // Contas do PlanoContas
    @GetMapping("/{planoContasId}/contas")
    public APIResponse<ArrayList<ContaContabilDTO>> listarContas(@PathVariable UUID planoContasId) {
        var contas = new ArrayList<ContaContabilDTO>();
        ExampleMatcher example = ExampleMatcher.matchingAny().withIgnoreNullValues();
        contaContabilRepository.findAll(Example.of(new ContaContabilVM().setPlanoContasId(planoContasId), example))
                .forEach(a -> contas.add(ContaContabilDTO.of(a)));
        return new APIResponse<ArrayList<ContaContabilDTO>>().setSucesso(true).setBody(contas);
    }

    @GetMapping("/{planoContasId}/contas/{id}")
    public APIResponse<ContaContabilDTO> listarContasPorId(@PathVariable UUID planoContasId, @PathVariable UUID id) {
        return new APIResponse<ContaContabilDTO>().setSucesso(true)
                .setBody(ContaContabilDTO.of(contaContabilRepository.findById(id).get()));
    }

    @PutMapping("/{planoContasId}/contas")
    @Transactional
    public APIResponse<ContaContabilDTO> incluirContas(@PathVariable UUID planoContasId,
            @RequestBody ContaContabilDTO conta) {
        conta.setPlanoContasId(planoContasId);
        var planoContas = planoContasRepository.findById(planoContasId).get();
        planoContas.getContas().add(conta.toContaContabilVM());
        planoContasRepository.save(planoContas);
        planoContasRepository.flush();
        return new APIResponse<ContaContabilDTO>().setSucesso(true);
    }

    @PostMapping("/{planoContasId}/contas/{id}")
    public APIResponse<ContaContabilDTO> alterarContas(@PathVariable UUID planoContasId, @PathVariable UUID id,
            @RequestBody ContaContabilDTO contas) {
        var conta = contaContabilRepository.findById(id).get();
        conta.setCodigo(contas.getCodigo()).setDescricao(contas.getDescricao()).setNatureza(contas.getNatureza())
                .setDataInicio(contas.getDataInicio()).setDataFim(contas.getDataFim());
        contaContabilRepository.saveAndFlush(conta);
        return new APIResponse<ContaContabilDTO>().setSucesso(true).setMensagem("Teste OK!");
    }

    @DeleteMapping("/{planoContasId}/contas/{id}")
    public APIResponse<ContaContabilDTO> excluirContas(@PathVariable UUID planoContasId, @PathVariable UUID id) {
        contaContabilRepository.deleteById(id);
        return new APIResponse<ContaContabilDTO>().setSucesso(true).setMensagem("Teste OK!");
    }
}

package br.com.banco.controller;

import br.com.banco.dto.SaldoResponse;
import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transferencia")
@CrossOrigin(origins = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public Page<Transferencia> exibirTransferencias(@RequestParam String dataInicio,
                                                    @RequestParam String dataFim,
                                                    @RequestParam String nomeOperadorTransacao,
                                                    @PageableDefault(sort= "id", direction = Sort.Direction.DESC, page = 0, size = 9) Pageable pageable
                                                            ) throws Exception {
        return transferenciaService.exibirTransferencias(dataInicio, dataFim, nomeOperadorTransacao,pageable);
    }

    @GetMapping(value = "/saldo")
    public SaldoResponse exibirSaldos(@RequestParam String dataInicio,
                                            @RequestParam String dataFim,
                                            @RequestParam String nomeOperadorTransacao) throws Exception {
        return transferenciaService.exibirSaldos(dataInicio, dataFim, nomeOperadorTransacao);
    }

    @GetMapping(value = "/nomes")
    public List<String> exibirNomeOperadorTransacao(@RequestParam String nome) throws Exception {
        return transferenciaService.exibirNomesOperadoresTransacao(nome);
    }

}

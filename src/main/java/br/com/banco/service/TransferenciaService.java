package br.com.banco.service;


import br.com.banco.dto.SaldoResponse;
import br.com.banco.dto.TransferenciaResponse;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ITransferenciaRepository;
//import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TransferenciaService {

    @Autowired
    private ITransferenciaRepository iTransferenciaRepository;

    public Page<Transferencia> exibirTransferencias(String dataInicio, String dataFim, String nomeOperadorTransacao, Pageable pageable) throws Exception {

        // Sem filtro
        if (dataInicio.isEmpty() && dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
             return iTransferenciaRepository.findTransferencias(pageable);
        }
        //apenas data inicial no filtro
        if (!dataInicio.isEmpty() && dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            return iTransferenciaRepository.findAllByDataInicial(DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"), pageable);
        }
        //apenas data final no filtro
        if (dataInicio.isEmpty() && !dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            return iTransferenciaRepository.findAllByDataFinal(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"), pageable);
        }
        //apenas nome do operador no filtro
        if (dataInicio.isEmpty() && dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            return iTransferenciaRepository.findAllByNomeOperadorTransacao("%" + nomeOperadorTransacao + "%", pageable);
        }
        //data inicio e data fim no filtro
        if (!dataInicio.isEmpty() && !dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            if (DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy").isAfter(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"))) {
                throw new Exception("A data inicial não pode ser maior que a data final!");
            }
            return iTransferenciaRepository.findAllBetweenDataInicialAndDataFim(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"), pageable
            );
        }
        //data inicio e nome operador no filtro
        if (!dataInicio.isEmpty() && dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            return iTransferenciaRepository.findAllByDataInicialAndNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%", pageable
            );
        }
        //data final e nome operador no filtro
        if (dataInicio.isEmpty() && !dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            return iTransferenciaRepository.findAllByDataFinalAndNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%",
                    pageable
            );
        }
        //todos os campos filtro
        if (!dataInicio.isEmpty() && !dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            if (DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy").isAfter(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"))) {
                throw new Exception("A data inicial não pode ser maior que a data final!");
            }
            return iTransferenciaRepository.findAllBetweenDataInicialAndDataFinalWithNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%",
                    pageable
            );
        }
        throw new Exception("Erro");
    }

    public SaldoResponse exibirSaldos(String dataInicio, String dataFim, String nomeOperadorTransacao) throws Exception {

        // Sem filtro
        if (dataInicio.isEmpty() && dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> transferencias = iTransferenciaRepository.findTransferencias();

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(transferencias))
                    .valorPeriodo(calcularSaldo(transferencias))
                    .build();
        }
         //apenas data inicial no filtro
        if (!dataInicio.isEmpty() && dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllByDataInicial(DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"));

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        //apenas data final no filtro
        if (dataInicio.isEmpty() && !dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllByDataFinal(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"));

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        //apenas nome do operador no filtro
        if (dataInicio.isEmpty() && dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro =iTransferenciaRepository.findAllByNomeOperadorTransacao("%" + nomeOperadorTransacao + "%");

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        //data inicio e data fim no filtro
        if (!dataInicio.isEmpty() && !dataFim.isEmpty() && nomeOperadorTransacao.isEmpty()) {
            if (DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy").isAfter(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"))) {
                throw new Exception("A data inicial não pode ser maior que a data final!");
            }
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllBetweenDataInicialAndDataFim(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy")
            );

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        //data inicio e nome operador no filtro
        if (!dataInicio.isEmpty() && dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllByDataInicialAndNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%"
            );

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();

        }
        //data final e nome operador no filtro
        if (dataInicio.isEmpty() && !dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllByDataFinalAndNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%"
            );

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        //todos os campos filtro
        if (!dataInicio.isEmpty() && !dataFim.isEmpty() && !nomeOperadorTransacao.isEmpty()) {
            if (DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy").isAfter(DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"))) {
                throw new Exception("A data inicial não pode ser maior que a data final!");
            }
            List<Transferencia> allTransferencias = iTransferenciaRepository.findTransferencias();
            List<Transferencia> transferenciasFiltro = iTransferenciaRepository.findAllBetweenDataInicialAndDataFinalWithNomeOperadorTransacao(
                    DateUtil.toLocalDate(dataInicio, "dd-MM-yyyy"),
                    DateUtil.toLocalDate(dataFim, "dd-MM-yyyy"),
                    "%" + nomeOperadorTransacao + "%"
            );

            return SaldoResponse.builder()
                    .valorTotal(calcularSaldo(allTransferencias))
                    .valorPeriodo(calcularSaldo(transferenciasFiltro))
                    .build();
        }
        throw new Exception("Erro");
    }

    public BigDecimal calcularSaldo( List<Transferencia> transferencias){
        BigDecimal valor = transferencias.stream().map(Transferencia::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        return valor;
    }

    public List<String> exibirNomesOperadoresTransacao(String nome) {
        if (nome.isEmpty()) {
            List<Transferencia> transferencias = iTransferenciaRepository.findAll();

            List<String> nomes = new ArrayList<>();

            System.out.println("aa" + transferencias);

            transferencias.stream().forEach(transferencia -> {
                if (transferencia.getNomeOperadorTransacao() != null) {
                    nomes.add(transferencia.getNomeOperadorTransacao());
                    Set<String> listaNomesUnicos = new HashSet();
                    listaNomesUnicos.addAll(nomes);

                    nomes.clear();
                    for (String y : listaNomesUnicos) {
                        nomes.add(y);
                    }
                }
            });

            return nomes;
        }

        List<Transferencia> transferencias = iTransferenciaRepository.findByNomeOperadorTransacaoLike("%" + nome + "%");

        List<String> nomes = new ArrayList<>();

        transferencias.stream().forEach(x -> {
            nomes.add(x.getNomeOperadorTransacao());
            Set<String> listaNomesUnicos = new HashSet();
            listaNomesUnicos.addAll(nomes);

            nomes.clear();
            for (String y : listaNomesUnicos) {
                nomes.add(y);
            }
        });
        return nomes;
    }

}

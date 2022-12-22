/*
 package br.com.banco.repository;

import br.com.banco.dto.TransferenciaResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransferenciaRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<TransferenciaResponse> findAll(){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia");

        final Query query = entityManager.createNativeQuery(sb.toString());

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }

    public List<TransferenciaResponse> findAllByDataInicial(LocalDate dataInicial){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) >= ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataInicial);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }

    public List<TransferenciaResponse> findAllByDataFinal(LocalDate dataFinal){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) <= ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataFinal);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
    public List<TransferenciaResponse> findAllByNomeOperadorTransacao(String nomeOperadorTransacao){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE nome_operador_transacao = ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, nomeOperadorTransacao);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
    public List<TransferenciaResponse> findAllBetweenDataInicialAndDataFim(LocalDate dataInicial, LocalDate dataFinal){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) >= ? and cast(data_transferencia as Date) <= ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataInicial);
        query.setParameter(2, dataFinal);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
    public List<TransferenciaResponse> findAllByDataInicialAndNomeOperadorTransacao(LocalDate dataInicial, String nomeOperadorTransacao){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) >= ? and nome_operador_transacao = ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataInicial);
        query.setParameter(2, nomeOperadorTransacao);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
    public List<TransferenciaResponse> findAllByDataFinalAndNomeOperadorTransacao(LocalDate dataFinal, String nomeOperadorTransacao){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) <= ? and nome_operador_transacao = ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataFinal);
        query.setParameter(2, nomeOperadorTransacao);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
    public List<TransferenciaResponse> findAllBetweenDataInicialAndDataFinalWithNomeOperadorTransacao(LocalDate dataFinal, LocalDate dataFinal, String nomeOperadorTransacao){
        StringBuilder sb = new StringBuilder();

        sb.append("select  id, cast(data_transferencia as Date), valor, tipo, nome_operador_transacao, conta_id ");
        sb.append("from transferencia ");
        sb.append("WHERE cast(data_transferencia as Date) <= ? and nome_operador_transacao = ?");

        final Query query = entityManager.createNativeQuery(sb.toString());

        query.setParameter(1, dataFinal);
        query.setParameter(2, nomeOperadorTransacao);

        List<Object[]> lista = query.getResultList();

        List<TransferenciaResponse> response = new ArrayList<>();

        lista.stream().forEach(posicao -> {
            response.add(TransferenciaResponse.builder()
                            .id((BigInteger) posicao[0])
                            .dataTransferencia((Date) posicao[1])
                            .valor((BigDecimal) posicao[2])
                            .tipo((String) posicao[3])
                            .nomeOperadorTransacao((String) posicao[4])
                            .contaId((Integer) posicao[5])
                    .build());
        });
        return response;
    }
}
*/
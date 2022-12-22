package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query(value = "SELECT * FROM transferencia",
            countQuery = "SELECT count(*) FROM transferencia",
            nativeQuery = true)
    Page<Transferencia> findTransferencias(Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) >= :dataInicial",
            countQuery = "SELECT count(*) FROM transferencia where cast(data_transferencia as Date) >= :dataInicial",
            nativeQuery = true)
    Page<Transferencia> findAllByDataInicial(LocalDate dataInicial, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) <= :dataFinal",
            countQuery = "SELECT count(*) FROM transferencia where cast(data_transferencia as Date) <= :dataFinal",
            nativeQuery = true)
    Page<Transferencia> findAllByDataFinal(LocalDate dataFinal, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            countQuery = "SELECT count(*) FROM transferencia where upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            nativeQuery = true)
    Page<Transferencia> findAllByNomeOperadorTransacao(String nomeOperadorTransacao, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) BETWEEN :dataInicial and :dataFim",
            countQuery = "SELECT count(*) FROM transferencia WHERE cast(data_transferencia as Date) BETWEEN :dataInicial and :dataFim",
            nativeQuery = true)
    Page<Transferencia> findAllBetweenDataInicialAndDataFim(LocalDate dataInicial, LocalDate dataFim, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) >= :dataInicial and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            countQuery = "SELECT count(*) FROM transferencia WHERE cast(data_transferencia as Date) >= :dataInicial and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            nativeQuery = true)
    Page<Transferencia> findAllByDataInicialAndNomeOperadorTransacao(LocalDate dataInicial, String nomeOperadorTransacao, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) <= :dataFim and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            countQuery = "SELECT count(*) FROM transferencia" +
                    " WHERE cast(data_transferencia as Date) <= :dataFim and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            nativeQuery = true)
    Page<Transferencia> findAllByDataFinalAndNomeOperadorTransacao(LocalDate dataFim, String nomeOperadorTransacao, Pageable pageable);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) BETWEEN :dataInicio and :dataFim and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            countQuery = "SELECT count(*) FROM transferencia" +
                    "WHERE cast(data_transferencia as Date) BETWEEN :dataInicio and :dataFim and upper(nome_operador_transacao) like upper(:nomeOperadorTransacao)",
            nativeQuery = true)
    Page<Transferencia> findAllBetweenDataInicialAndDataFinalWithNomeOperadorTransacao(LocalDate dataInicio,LocalDate dataFim, String nomeOperadorTransacao, Pageable pageable);


    @Query(value = "select * from transferencia " +
            "WHERE upper(nome_operador_transacao) like upper(:nome)", nativeQuery = true)
    List<Transferencia> findByNomeOperadorTransacaoLike(String nome);

    //Para calcular os saldos

    @Query(value = "SELECT * FROM transferencia",nativeQuery = true)
    List<Transferencia> findTransferencias();

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) >= :dataInicial", nativeQuery = true)
    List<Transferencia> findAllByDataInicial(LocalDate dataInicial);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) <= :dataFinal",nativeQuery = true)
    List<Transferencia> findAllByDataFinal(LocalDate dataFinal);

    @Query(value = "select * from transferencia " +
            "WHERE nome_operador_transacao = :nomeOperadorTransacao",nativeQuery = true)
    List<Transferencia> findAllByNomeOperadorTransacao(String nomeOperadorTransacao);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) BETWEEN :dataInicial and :dataFim",nativeQuery = true)
    List<Transferencia> findAllBetweenDataInicialAndDataFim(LocalDate dataInicial, LocalDate dataFim);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) >= :dataInicial and nome_operador_transacao = :nomeOperadorTransacao", nativeQuery = true)
    List<Transferencia> findAllByDataInicialAndNomeOperadorTransacao(LocalDate dataInicial, String nomeOperadorTransacao);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) >= :dataFim and nome_operador_transacao = :nomeOperadorTransacao",nativeQuery = true)
    List<Transferencia> findAllByDataFinalAndNomeOperadorTransacao(LocalDate dataFim, String nomeOperadorTransacao);

    @Query(value = "select * from transferencia " +
            "WHERE cast(data_transferencia as Date) BETWEEN :dataInicio and :dataFim and nome_operador_transacao = :nomeOperadorTransacao",nativeQuery = true)
    List<Transferencia> findAllBetweenDataInicialAndDataFinalWithNomeOperadorTransacao(LocalDate dataInicio,LocalDate dataFim, String nomeOperadorTransacao);


}

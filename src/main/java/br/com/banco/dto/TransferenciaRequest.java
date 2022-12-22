package br.com.banco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaRequest {

    private Date dataInicio;
    private Date dataFim;
    private String nomeOperadorTransacao;

}

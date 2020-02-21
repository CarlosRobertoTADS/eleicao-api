package br.com.eleicao.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultadoDTO {

    String namePauta;

    String sessao;

    private Integer resultYes;

    private Integer resultNo;

    private Integer voteAll;
}

package br.com.eleicao.dto;

import br.com.eleicao.domain.Associado;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

    private Integer id;
    private String voto;
    private LocalDateTime date;
    private Associado nameAssociado;
    private SessaoDTO sessao;

}

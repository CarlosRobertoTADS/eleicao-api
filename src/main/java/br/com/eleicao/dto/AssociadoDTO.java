package br.com.eleicao.dto;


import br.com.eleicao.domain.Sessao;
import br.com.eleicao.domain.Voto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDTO implements Serializable {

    private Integer id;
    private String cpf;
    private String nome;
    private Sessao sessao;
    private Voto voto;
}

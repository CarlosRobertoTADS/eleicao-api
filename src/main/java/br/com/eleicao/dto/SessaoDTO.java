package br.com.eleicao.dto;

import br.com.eleicao.domain.Associado;
import br.com.eleicao.domain.Pauta;
import br.com.eleicao.domain.Voto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessaoDTO {

    private Integer id;
    private String dateFinal;
    private String waitingTime;
    private PautaDTO pauta;

}

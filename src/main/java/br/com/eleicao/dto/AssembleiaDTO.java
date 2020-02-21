package br.com.eleicao.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssembleiaDTO implements Serializable {
    private Integer id;
    private String nome;
    private LocalDateTime date;

}

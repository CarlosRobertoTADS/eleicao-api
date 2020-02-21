package br.com.eleicao.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO implements Serializable {

    private Integer id;
    private String nome;
}

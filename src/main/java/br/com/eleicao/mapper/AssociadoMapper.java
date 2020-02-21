package br.com.eleicao.mapper;

import br.com.eleicao.domain.Associado;
import br.com.eleicao.dto.AssociadoDTO;
import br.com.eleicao.dto.SessaoDTO;

public class AssociadoMapper {

    public Associado convertEntity(AssociadoDTO dto){
        return  Associado.builder()
                .id(dto.getId())
                .cpf(dto.getCpf())
                .name(dto.getNome())
                .build();
    }

    public AssociadoDTO convertDTO(Associado entity){
        return  AssociadoDTO.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getName())
                .build();
    }
}

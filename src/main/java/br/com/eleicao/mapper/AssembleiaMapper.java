package br.com.eleicao.mapper;

import br.com.eleicao.domain.Assembleia;

import br.com.eleicao.dto.AssembleiaDTO;
import br.com.eleicao.dto.AssociadoDTO;

public class AssembleiaMapper {

    public Assembleia convertEntity(AssembleiaDTO dto){
        return  Assembleia.builder()
                .id(dto.getId())
                .name(dto.getNome())
                .date(dto.getDate())
                .build();
    }

    public AssembleiaDTO convertDTO(Assembleia entity){
        return  AssembleiaDTO.builder()
                .id(entity.getId())
                .nome(entity.getName())
                .date(entity.getDate())
                .build();
    }
}

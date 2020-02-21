package br.com.eleicao.mapper;

import br.com.eleicao.domain.Pauta;
import br.com.eleicao.dto.PautaDTO;

public class PautaMapper {

    public Pauta convertEntity(PautaDTO dto){
        return Pauta.builder()
                .id(dto.getId())
                .name(dto.getNome())
                .build();
    }

    public PautaDTO convertDto(Pauta entity){
        return PautaDTO.builder()
                .id(entity.getId())
                .nome(entity.getName())
                .build();
    }
}

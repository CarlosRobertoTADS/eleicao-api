package br.com.eleicao.mapper;

import br.com.eleicao.domain.Associado;
import br.com.eleicao.domain.Sessao;
import br.com.eleicao.domain.Voto;
import br.com.eleicao.dto.AssociadoDTO;
import br.com.eleicao.dto.VotoDTO;

public class VotoMapper {

    public Voto convertEntity(VotoDTO dto) {
        return Voto.builder()
                .id(dto.getId())
                .associado(Associado.builder().name(dto.getNameAssociado().getName()).build())
                .voto(dto.getVoto())
                .sessao(Sessao.builder().id(dto.getSessao().getId()).build())
                .build();
    }


    public VotoDTO convertDTO(Voto entity) {
        return  VotoDTO.builder()
                .id(entity.getId())
                .nameAssociado(Associado.builder()
                        .id(entity.getId())
                        .cpf(entity.getAssociado().getCpf())
                        .build())
                .build();
    }
}

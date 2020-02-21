package br.com.eleicao.mapper;

import br.com.eleicao.domain.Pauta;
import br.com.eleicao.domain.Sessao;
import br.com.eleicao.dto.PautaDTO;
import br.com.eleicao.dto.SessaoDTO;

import java.time.LocalDateTime;

public class SessaoMapper {

    private Integer id;
    private int numero;
    private LocalDateTime date;

    public Sessao convertEntity(SessaoDTO dto) {
        return Sessao.builder()
                .id(dto.getId())
                .pauta(Pauta.builder().id(dto.getPauta().getId()).build())
                .waitingTime(validarTempoSessao(dto.getWaitingTime()))
                .dateFinal(dto.getDateFinal())
                .build();
    }




    public SessaoDTO entityToDto(Sessao entity) {
        return SessaoDTO.builder()
                .id(entity.getId())
                .waitingTime(validarTempoSessao(entity.getWaitingTime()))
                .dateFinal(entity.getDateFinal())
                .pauta(PautaDTO.builder()
                        .id(entity.getPauta().getId())
                        .nome(entity.getPauta().getName())
                        .build())
                .build();
    }

    private String validarTempoSessao(String waitingTime) {
        if(waitingTime.equals(""))
            return "60";
        else
            return waitingTime;
    }
}


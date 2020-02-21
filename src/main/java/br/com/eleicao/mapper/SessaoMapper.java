package br.com.eleicao.mapper;

import br.com.eleicao.domain.Sessao;
import br.com.eleicao.dto.SessaoDTO;

import java.time.LocalDateTime;

public class SessaoMapper {

    private Integer id;
    private int numero;
    private LocalDateTime date;

    public Sessao convertEntity(SessaoDTO dto) {
        return Sessao.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .date(dto.getDate())
                .waitingTime(validarTempoSessao(dto.getWaitingTime()))
                .dateFinal(dto.getDateFinal())
                .build();
    }




    public SessaoDTO entityToDto(Sessao entity) {
        return SessaoDTO.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .date(entity.getDate())
                .waitingTime(validarTempoSessao(entity.getWaitingTime()))
                .dateFinal(entity.getDateFinal())
                .build();
    }

    private String validarTempoSessao(String waitingTime) {
        if(waitingTime.equals(""))
            return "60";
        else
            return waitingTime;
    }
}

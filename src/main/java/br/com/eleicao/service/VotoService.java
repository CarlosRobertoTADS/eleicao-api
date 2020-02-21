package br.com.eleicao.service;

import br.com.eleicao.dto.ResultadoDTO;
import br.com.eleicao.dto.VotoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VotoService {

    List<VotoDTO> findAll();

    VotoDTO findById(Integer id);

    VotoDTO save(VotoDTO voto);

    ResultadoDTO resultadoVotacao(Integer pautaId, Integer sessaoId);


}

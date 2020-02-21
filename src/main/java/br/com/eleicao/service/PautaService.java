package br.com.eleicao.service;

import br.com.eleicao.dto.PautaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PautaService {

    List<PautaDTO> findAll();

    PautaDTO findById(Integer id);

    PautaDTO save(PautaDTO pauta);

}

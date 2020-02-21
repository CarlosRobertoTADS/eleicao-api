package br.com.eleicao.service;

import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.dto.AssembleiaDTO;
import br.com.eleicao.dto.AssociadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssembleiaService  {

    List<AssembleiaDTO> findAll();

    AssembleiaDTO findById(Integer id);

    AssembleiaDTO save(AssembleiaDTO assembleia);

    void delete(Integer id);

}

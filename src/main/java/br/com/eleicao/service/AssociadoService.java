package br.com.eleicao.service;

import br.com.eleicao.dto.AssociadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssociadoService {

    List<AssociadoDTO> findAll();

    AssociadoDTO findById(Integer id);

    AssociadoDTO save(AssociadoDTO associado);

    void delete(Integer id);

}

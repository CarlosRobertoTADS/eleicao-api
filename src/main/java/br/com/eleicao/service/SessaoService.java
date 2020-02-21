package br.com.eleicao.service;

import br.com.eleicao.dto.SessaoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessaoService {

    List<SessaoDTO> findAll();

    SessaoDTO findById(Integer id);

    SessaoDTO save(SessaoDTO sessao);

}

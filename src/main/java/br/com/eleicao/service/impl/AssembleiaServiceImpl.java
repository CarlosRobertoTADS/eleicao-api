package br.com.eleicao.service.impl;

import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.dto.AssembleiaDTO;
import br.com.eleicao.exceptions.ResourceNotFoundException;
import br.com.eleicao.mapper.AssembleiaMapper;
import br.com.eleicao.repository.AssembleiaRepository;
import br.com.eleicao.service.AssembleiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssembleiaServiceImpl implements AssembleiaService {

    @Autowired
    private AssembleiaRepository assembleiaRepository;


    @Override
    public List<AssembleiaDTO> findAll() {
        List<AssembleiaDTO> associadoDtos = new ArrayList<>();
        assembleiaRepository.findAll().forEach(associado ->
                associadoDtos.add(new AssembleiaMapper().convertDTO(associado)));
        return associadoDtos;
    }

    @Override
    public AssembleiaDTO findById(Integer id) {
       Optional<Assembleia> assembleia = assembleiaRepository.findById(id);
        return new AssembleiaMapper().convertDTO(assembleia.orElseThrow(() -> new ResourceNotFoundException("Não encontrado")));
    }

    @Override
    public AssembleiaDTO save(AssembleiaDTO assembleia) {
        return new AssembleiaMapper().convertDTO(assembleiaRepository.save(new AssembleiaMapper().convertEntity(assembleia)));
    }

    @Override
    public void delete(Integer id) {
        assembleiaRepository.deleteById(id);
    }
}

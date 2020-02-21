package br.com.eleicao.service.impl;


import br.com.eleicao.domain.Pauta;
import br.com.eleicao.dto.PautaDTO;
import br.com.eleicao.exceptions.ResourceNotFoundException;
import br.com.eleicao.mapper.PautaMapper;
import br.com.eleicao.repository.PautaRepository;
import br.com.eleicao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PautaServiceImpl implements PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public List<PautaDTO> findAll() {
        List<PautaDTO> arrayList = new ArrayList<>();
        pautaRepository.findAll().forEach(pauta ->
                arrayList.add(new PautaMapper().convertDto(pauta))
        );
        return arrayList;
    }

    @Override
    public PautaDTO findById(Integer id) {
        Optional<Pauta> pauta = pautaRepository.findById(id);
        return new PautaMapper()
                .convertDto(pauta.orElseThrow(()-> new ResourceNotFoundException("Não encontrado")));
    }

    @Override
    public PautaDTO save(PautaDTO pauta) {
        return new PautaMapper().convertDto(pautaRepository.save(new PautaMapper().convertEntity(pauta)));
    }
}

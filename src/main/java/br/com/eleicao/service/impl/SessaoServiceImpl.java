package br.com.eleicao.service.impl;

import br.com.eleicao.domain.Sessao;
import br.com.eleicao.dto.SessaoDTO;
import br.com.eleicao.mapper.SessaoMapper;
import br.com.eleicao.repository.SessaoRepository;
import br.com.eleicao.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SessaoServiceImpl implements SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    public List<SessaoDTO> findAll() {
        List<SessaoDTO> arrayList = new ArrayList<>();
        sessaoRepository.findAll().forEach(sessao ->
                arrayList.add(new SessaoMapper().entityToDto(sessao)));
        return arrayList;
    }

    @Override
    public SessaoDTO findById(Integer id) {
        Optional<Sessao> optional = sessaoRepository.findById(id);
        return new SessaoMapper().entityToDto(optional.get());
    }

    @Override
    public SessaoDTO save(SessaoDTO sessao) {
        Sessao save = new SessaoMapper().convertEntity(sessao);
        save.setDateFinal(dataHoraFinalDaVotacao(sessao));
        return new SessaoMapper().entityToDto(sessaoRepository.save(save));
    }

    private String dataHoraFinalDaVotacao(SessaoDTO sessaoDto) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        gc.setTimeInMillis(new Date().getTime());

        gc.add(Calendar.SECOND, Integer.parseInt(sessaoDto.getWaitingTime()));

        return sdf2.format(gc.getTime());
    }

}

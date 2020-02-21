package br.com.eleicao.service.impl;

import br.com.eleicao.domain.Sessao;
import br.com.eleicao.domain.Voto;
import br.com.eleicao.dto.*;
import br.com.eleicao.exceptions.DefeaultException;
import br.com.eleicao.exceptions.ResourceNotFoundException;
import br.com.eleicao.mapper.SessaoMapper;
import br.com.eleicao.mapper.VotoMapper;
import br.com.eleicao.repository.SessaoRepository;
import br.com.eleicao.repository.VotoRepository;
import br.com.eleicao.service.FeingService;
import br.com.eleicao.service.PautaService;
import br.com.eleicao.service.SessaoService;
import br.com.eleicao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoRepository votoRepository;
    @Autowired
    private PautaService pautaService;
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private FeingService feingService;

    @Override
    public List<VotoDTO> findAll() {
        List<VotoDTO> arrayList = new ArrayList<>();
        votoRepository.findAll().forEach(voto ->
                arrayList.add(new VotoMapper().convertDTO(voto)));
        return arrayList;
    }

    @Override
    public VotoDTO findById(Integer id) {

        return new VotoMapper().convertDTO(objectExists(id));
    }

    private Voto objectExists(Integer id) {
        Optional<Voto> votoOptional = votoRepository.findById(id);
        return votoOptional.orElseThrow(() -> new ResourceNotFoundException("Não Encontrado"));
    }

    @Override
    public VotoDTO save(VotoDTO dto) {
        //COMENTEI A VALIDAÇÃO DO CPF POIS API DISPONIBILIZADA ESTÁ FORA DO AR
//        validarCpf(dto.getNameAssociado().getCpf());
        validarVotoDoAssociado(dto);
        Sessao sessao = new SessaoMapper().convertEntity(sessaoService.findById(dto.getSessao().getId()));
        validaTempoVotacao(sessao);
        return new VotoMapper().convertDTO(votoRepository.save(new VotoMapper().convertEntity(dto)));
    }

    private void validarCpf(String cpf) {
        ValidaCpf validaCpf = feingService.validaCpf(cpf);
        if (!validaCpf.getStatus().equals("ABLE_TO_VOTE"))
            throw new DefeaultException(
                    messageSource.getMessage("cpf.inapto", null, Locale.getDefault())
            );
    }

    @Override
    public ResultadoDTO resultadoVotacao(Integer pautaId, Integer sessaoId) {
        SessaoDTO sessaoDto = sessaoService.findById(sessaoId);
        PautaDTO pautaDto = pautaService.findById(pautaId);
        Integer votosSim = votoRepository.findByVoto("sim").size();
        Integer votosNao = votoRepository.findByVoto("nao").size();
        Integer totalGeralVotos = votosNao + votosSim;

        return ResultadoDTO.builder()
                .sessao(String.valueOf(sessaoDto.getId()))
                .namePauta(pautaDto.getNome())
                .voteAll(totalGeralVotos)
                .resultNo(votosNao)
                .resultYes(votosSim)
                .build();
    }

    public void validaTempoVotacao(Sessao sessao) {
        if (convertStringToDate(convertDateToString(new Date())).getTime() > convertStringToDate(sessao.getDateFinal()).getTime())
            throw new DefeaultException(
                    messageSource.getMessage("waitingTime.esgotado", null, Locale.getDefault())
            );
    }

    private void validarVotoDoAssociado(VotoDTO dto) {
        Optional<Voto> optionalVoto = votoRepository.findByAssociadoCpfAndSessaoId(dto.getNameAssociado().getCpf(), dto.getSessao().getId());
        if (optionalVoto.isPresent())
            throw new DefeaultException(
                    messageSource.getMessage("cpf.encontrado", null, Locale.getDefault())
            );
    }

    public Date convertStringToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        try {
            return  format.parse(date);
        } catch (ParseException e) {
            return  null;
        }

    }

    public String convertDateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateToStr = format.format(date);
        return dateToStr;

    }

}

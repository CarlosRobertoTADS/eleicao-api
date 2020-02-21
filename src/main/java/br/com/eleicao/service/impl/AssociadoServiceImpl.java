package br.com.eleicao.service.impl;

import br.com.eleicao.domain.Associado;
import br.com.eleicao.dto.AssociadoDTO;
import br.com.eleicao.exceptions.ConstraintException;
import br.com.eleicao.exceptions.ResourceNotFoundException;
import br.com.eleicao.mapper.AssociadoMapper;
import br.com.eleicao.repository.AssociadoReposiroty;
import br.com.eleicao.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoReposiroty associadoReposiroty;

    @Autowired
    private MessageSource messageSource;

    @Override
    public List<AssociadoDTO> findAll() {
        List<AssociadoDTO> associadoDtos = new ArrayList<>();
        associadoReposiroty.findAll().forEach(associado ->
                associadoDtos.add(new AssociadoMapper().convertDTO(associado)));
        return associadoDtos;
    }

    @Override
    public AssociadoDTO findById(Integer id) {
        entityExists(id);
        return new AssociadoMapper().convertDTO(entityExists(id));
    }

    @Override
    public AssociadoDTO save(AssociadoDTO associado) {
        return new AssociadoMapper().convertDTO(associadoReposiroty.save(new AssociadoMapper().convertEntity(associado)));
    }

    @Override
    public void delete(Integer id) {
        try {
            entityExists(id);
            associadoReposiroty.deleteById(id);
        } catch (Exception e) {
            throw new ConstraintException(
                    messageSource.getMessage("constraint.exception", null, Locale.getDefault())
            );
        }


    }

    private Associado entityExists(Integer id) {
        Optional<Associado> optionalAssociado = associadoReposiroty.findById(id);
        return optionalAssociado.orElseThrow(() -> new ResourceNotFoundException(
                messageSource.getMessage("associado.notfoud", null, Locale.getDefault())));
    }
    }




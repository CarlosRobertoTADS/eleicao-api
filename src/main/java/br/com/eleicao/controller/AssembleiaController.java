package br.com.eleicao.controller;


import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.dto.AssembleiaDTO;
import br.com.eleicao.repository.AssembleiaRepository;
import br.com.eleicao.service.AssembleiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Assembleia Controller")
@RestController
@RequestMapping(value = "/assembleia")
public class AssembleiaController {

    @Autowired
    private AssembleiaService assembleiaService;



    @GetMapping
    public List<AssembleiaDTO> findAll() {
        return assembleiaService.findAll();
    }

    @GetMapping("/{id}")
    public AssembleiaDTO findById(@PathVariable Integer id) {
        return assembleiaService.findById(id);
    }

    @PostMapping
    public AssembleiaDTO save(@Valid @RequestBody AssembleiaDTO dto) {
        return assembleiaService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        assembleiaService.delete(id);
    }


}

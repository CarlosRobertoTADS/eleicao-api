package br.com.eleicao.controller;

import br.com.eleicao.dto.AssembleiaDTO;
import br.com.eleicao.dto.AssociadoDTO;
import br.com.eleicao.service.AssembleiaService;
import br.com.eleicao.service.AssociadoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Associado Controller")
@RestController
@RequestMapping(value = "/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public List<AssociadoDTO> findAll() {
        return associadoService.findAll();
    }

    @GetMapping("/{id}")
    public AssociadoDTO findById(@PathVariable Integer id) {
        return associadoService.findById(id);
    }

    @PostMapping
    public AssociadoDTO save(@Valid @RequestBody AssociadoDTO dto) {
        return associadoService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        associadoService.delete(id);
    }

}

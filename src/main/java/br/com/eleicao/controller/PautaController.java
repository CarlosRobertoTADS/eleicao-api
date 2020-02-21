package br.com.eleicao.controller;

import br.com.eleicao.dto.PautaDTO;
import br.com.eleicao.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Pauta Controller")
@RestController
@RequestMapping(value = "/pauta")
public class PautaController {

    @Autowired
    private PautaService pautasService;

    @GetMapping
    public List<PautaDTO> findAll(){
        return  pautasService.findAll();
    }

    @GetMapping("/{id}")
    public PautaDTO findById(@PathVariable Integer id){
        return  pautasService.findById(id);
    }

    @PostMapping
    @ApiOperation("Registrar Pauta")
    public PautaDTO save(@RequestBody PautaDTO dto){
        return  pautasService.save(dto);
    }
}

package br.com.eleicao.controller;


import br.com.eleicao.dto.SessaoDTO;
import br.com.eleicao.service.SessaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Sessao Controller")
@RestController
@RequestMapping(value = "/sessao")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    public List<SessaoDTO> findAll() {
        return sessaoService.findAll();
    }

    @GetMapping("/{id}")
    public SessaoDTO findById(@PathVariable Integer id) {
        return sessaoService.findById(id);
    }

    @PostMapping
    @ApiOperation("Abrir sessão de votação, informar id da PAUTA, tempo da sessao em segundos <= 60")
    public SessaoDTO save(@RequestBody SessaoDTO dto) {
        return sessaoService.save(dto);
    }

}

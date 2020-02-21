package br.com.eleicao.controller;


import br.com.eleicao.dto.ResultadoDTO;
import br.com.eleicao.dto.VotoDTO;
import br.com.eleicao.service.VotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Voto Controller")
@RestController
@RequestMapping(value = "/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping
    public List<VotoDTO> findAll(){
        return  votoService.findAll();
    }

    @GetMapping("/{id}")
    public VotoDTO findById(@PathVariable Integer id){
        return  votoService.findById(id);
    }

    @PostMapping
    @ApiOperation("Votação, input de id e cpf ")
    public VotoDTO save(@RequestBody VotoDTO dto){
        return  votoService.save(dto);
    }

    @GetMapping("/resultado")
    @ApiOperation("Resultado da votação")
    public ResultadoDTO resultadoVotacao(
            @RequestParam(value = "pautaId") Integer pautaId,
            @RequestParam(value = "sessaoId") Integer sessaoId
    ){
        return votoService.resultadoVotacao(pautaId,sessaoId);
    }

}

package br.com.eleicao.service;

import br.com.eleicao.dto.ValidaCpf;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "validaCpf", url = "https://user-info.herokuapp.com")
public interface FeingService {
    @GetMapping(value = "/users/{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ValidaCpf validaCpf(@PathVariable String cpf);
}

package br.com.eleicao.repository;

import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Integer> {
}

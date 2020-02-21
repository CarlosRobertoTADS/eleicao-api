package br.com.eleicao.repository;

import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoReposiroty extends JpaRepository<Associado, Integer> {
}

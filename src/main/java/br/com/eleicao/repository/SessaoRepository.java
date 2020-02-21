package br.com.eleicao.repository;

import br.com.eleicao.domain.Assembleia;
import br.com.eleicao.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
}

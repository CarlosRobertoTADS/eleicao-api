package br.com.eleicao.repository;


import br.com.eleicao.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
    Optional<Voto> findByAssociadoCpfAndSessaoId(String cpf, Integer sessaoId);
    List<Voto> findByVoto(String voto);
}

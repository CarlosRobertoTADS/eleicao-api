package br.com.eleicao.domain;





import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "Associado")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ass_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "ass_nome", nullable = false)
    private String name;

    @Column(name = "ass_cpf", nullable = false)
    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "voto",
            joinColumns = @JoinColumn(name = "ass_id"),
            inverseJoinColumns = @JoinColumn(name = "ses_id"))
    Set<Sessao> sessaos;

    @OneToMany(mappedBy = "associado")
    Set<Voto> votos;



}

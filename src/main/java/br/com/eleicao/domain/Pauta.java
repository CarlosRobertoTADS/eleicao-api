package br.com.eleicao.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Pauta")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pauta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pau_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "pau_nome", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="asb_id")
    private Assembleia assembleia;

    @OneToMany(mappedBy="pauta", fetch = FetchType.EAGER)
    private Set<Sessao> sessao;

}

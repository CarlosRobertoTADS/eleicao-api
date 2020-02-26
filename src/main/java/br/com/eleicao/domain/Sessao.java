package br.com.eleicao.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "Sessao")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id", unique = true, nullable = false)
    private Integer id;

    @Column(name= "ses_dateFinal")
    private String dateFinal;

    @Column(name= "ses_time")
    private String waitingTime;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="pau_id")
    private Pauta pauta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessao")
    private List<Voto> votos;
}

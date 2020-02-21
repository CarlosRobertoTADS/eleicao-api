package br.com.eleicao.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    @Column(name = "ses_numero", nullable = false)
    private int number;

    @Column(name = "ses_date", nullable = false)
    private LocalDateTime date;

    @Column(name= "ses_dateFinal", nullable = false)
    private String dateFinal;

    @Column(name= "ses_time")
    private String waitingTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pau_id")
    private Pauta pauta;

    @OneToMany(mappedBy = "sessao")
    Set<Voto> votos;
}

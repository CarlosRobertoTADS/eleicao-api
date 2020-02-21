package br.com.eleicao.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "Voto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vot_id", unique = true, nullable = false)
    Integer id;

    private String voto ;

    @Column(name = "vot_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "ass_id")
    Associado associado;

    @ManyToOne
    @JoinColumn(name = "ses_id")
    Sessao sessao;


}

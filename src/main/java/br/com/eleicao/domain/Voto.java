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

    @Column(name = "vot_voto")
    private String voto ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ass_id")
    private Associado associado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ses_id")
    private Sessao sessao;


}

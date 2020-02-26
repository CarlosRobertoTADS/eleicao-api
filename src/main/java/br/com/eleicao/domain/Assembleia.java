package br.com.eleicao.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Assembleia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assembleia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asb_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "asb_nome")
    private String name;

    @Column(name = "asb_date")
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="assembleia")
    private Set<Pauta> pautas;


}

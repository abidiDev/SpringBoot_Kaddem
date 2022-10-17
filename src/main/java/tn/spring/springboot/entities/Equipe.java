package tn.spring.springboot.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idEquipe;
private String nomEquipe;
    @Enumerated(EnumType.STRING)
private Niveau niveau;
    @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToMany(mappedBy = "equipe")
    private Set<Etudiant> etudiant;
}

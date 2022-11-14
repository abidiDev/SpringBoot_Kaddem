package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@EqualsAndHashCode(exclude = {"attributeOfTypeList", "attributeOfTypeSet"})

public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idEquipe;
private String nomEquipe;
    @Enumerated(EnumType.STRING)
private Niveau niveau;
    @OneToOne
    @JsonIgnore

    private DetailEquipe detailEquipe;
    @ManyToMany

    private Set<Etudiant> etudiant;
}

package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Etudiant")
//c'est une annotation  lombok qui crée constructerur, getter , setter, hash, to string... !!!!! non recommandé parcequ'on a des associations
//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne

    private Departement departement;
    @ManyToMany(mappedBy = "etudiant")

    private Set<Equipe> equipe;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore

    private Set<Contrat> contrat;
}

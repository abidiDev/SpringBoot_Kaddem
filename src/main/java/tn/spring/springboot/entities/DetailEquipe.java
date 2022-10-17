package tn.spring.springboot.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe implements Serializable {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int idDetailEquipe;
   private long salle;
   private String thematique;
   @OneToOne(mappedBy = "detailEquipe")
   private Equipe equipe;


}

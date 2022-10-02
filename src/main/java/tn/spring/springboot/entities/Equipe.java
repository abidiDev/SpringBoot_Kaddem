package tn.spring.springboot.entities;

import javax.persistence.*;

@Entity
@Table
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idEquipe;
private String nomEquipe;
    @Enumerated(EnumType.STRING)
private Niveau niveau;
}

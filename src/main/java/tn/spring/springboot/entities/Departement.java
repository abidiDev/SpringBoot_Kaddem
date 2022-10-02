package tn.spring.springboot.entities;

import javax.persistence.*;

@Entity
@Table
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    private String nomDepart;
}

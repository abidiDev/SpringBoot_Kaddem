package tn.spring.springboot.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private int idContrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;
}

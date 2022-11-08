package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    @Query("SELECT departement FROM Departement departement , Etudiant etudiant where departement.idDepart = etudiant.departement.idDepart and etudiant.option =?1")
    List<Departement> retrieveDepartementByOptionEtudiant(Option op);
}

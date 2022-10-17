package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}

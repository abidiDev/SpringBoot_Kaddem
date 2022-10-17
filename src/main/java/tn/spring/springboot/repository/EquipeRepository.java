package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}

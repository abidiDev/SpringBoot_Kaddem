package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findEquipeByEtudiantIdEtudiant(Long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart (Long idEtudiant, Integer idDepart);


}

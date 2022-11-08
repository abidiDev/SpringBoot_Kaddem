package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findEquipeByEtudiantIdEtudiant(Long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart (Long idEtudiant, Integer idDepart);
    @Query("SELECT equipe FROM Equipe equipe, DetailEquipe detailEquipe where equipe.idEquipe=detailEquipe.equipe.idEquipe and(equipe.niveau=?1  and detailEquipe.thematique=?2) ")

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);

    @Modifying
    @Transactional
    @Query("delete from Equipe equipe where equipe.niveau =? 1")

    void deleteEquipeByNiveau( Niveau niveau);

}

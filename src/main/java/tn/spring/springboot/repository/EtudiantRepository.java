package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Option;

import javax.transaction.Transactional;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findEtudiantByPrenomEContains(String prenom);
    Etudiant findEtudiantByNomE(String nom);

    //List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);
    @Modifying
    @Transactional
    @Query("update Etudiant etudiant  set etudiant.option=:option where etudiant.idEtudiant=:idEtudiant ")
    void updateEtudiantByOption(@Param("option") Option option , @Param(("idEtudiant")) Long idEtudiant);




}

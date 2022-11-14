package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.springboot.entities.*;

import javax.transaction.Transactional;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findEtudiantByPrenomEContains(String prenom);
    Etudiant findEtudiantByNomEAndPrenomE(String nom, String prenom);
    List<Etudiant> findEtudiantByDepartement(Departement D);
    //List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);
    @Modifying
    @Transactional
    @Query("update Etudiant etudiant  set etudiant.option=:option where etudiant.idEtudiant=:idEtudiant ")
    void updateEtudiantByOption(@Param("option") Option option , @Param(("idEtudiant")) Long idEtudiant);




}

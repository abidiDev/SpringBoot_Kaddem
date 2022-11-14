package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tn.spring.springboot.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    @Query("SELECT  c FROM Contrat c where  c.dateDebutContrat >=? 1 and c.dateFinContrat <=? 2 ")
    List<Contrat> ListContratBetweenToDate( Date dateD , Date dateF);

}

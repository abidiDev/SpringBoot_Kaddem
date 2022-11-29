package tn.spring.springboot.service;

import lombok.Getter;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Departement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public interface IContrat {
    //List<String> messages=new ArrayList<String>();

    public List<Contrat> getAllContrats();
    public Contrat addContrat(Contrat c);
    public Contrat updateContrat(Contrat c);
    public void deleteDetailContrat(Integer id);
    public Contrat getContratById(Integer id);
    public Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    public List<String>  getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public Integer nbContratsValides(Date startDate, Date endDate);
    public void retrieveAndUpdateStatusContrat();
}

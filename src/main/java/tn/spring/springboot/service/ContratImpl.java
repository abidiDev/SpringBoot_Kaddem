package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Service
@AllArgsConstructor
@Getter

public class ContratImpl implements IContrat {
    public static List<String> messages=new ArrayList<String>();

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;



    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteDetailContrat(Integer id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        int nbContratValide = 0;
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE, prenomE);
        for (Contrat c : etudiant.getContrat()) {
            if (c.getArchive() == Boolean.TRUE) {
                nbContratValide = nbContratValide + 1;
            }

        }

        if (nbContratValide <= 4) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);

        }

        return ce;
    }

    public List<String> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.ListContratBetweenToDate(startDate, endDate);

        int ia=0,cloud=0,resau=0,securite=0;

        for (Contrat c: contrats) {

            switch (c.getSpecialite()){
                case IA: ia=ia+1;
                    break;

                case CLOUD:cloud=cloud+1;
                    break;

                case RESAU:resau=resau+1;
                    break;

                case SECURITE:securite=securite+1;
                    break;

            }
        }
        List<String> result=new ArrayList<String>();
        result.add("le montant de la specialite IA= "+ia*300+"DT");
        result.add("le montant de la specialite cloud= "+cloud*400+"DT");
        result.add("le montant de la specialite Resau= "+resau*350+"DT");
        result.add("le montant de la specialite securite= "+securite*450+"DT");
        return result;


    }
    public Integer nbContratsValides(Date startDate, Date endDate)
    {
        return contratRepository.ListContratBetweenToDate(startDate, endDate).size();

    }

    @Override
    @Scheduled(cron = "* * 13 * * *")
    public void retrieveAndUpdateStatusContrat() {
        messages=new ArrayList<String>();
        List<Contrat> contrats=contratRepository.findAll();
        List<Contrat> contratsToRenew=new ArrayList<Contrat>();
        Date todayDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        for (Contrat c: contrats) {



            if ( (todayDate.getTime()-c.getDateFinContrat().getTime())/(1000*60*60*24) <15 && (c.getDateFinContrat().getTime()-todayDate.getTime())/(1000*60*60*24) >0){

                contratsToRenew.add(c);
                c.setArchive(true);
                contratRepository.save(c);
            }

        }

        for (Contrat c: contratsToRenew) {
            messages.add("Bonjour "+c.getEtudiant().getNomE()+" "+c.getEtudiant().getPrenomE()+" étudiant dans la spécialité "+c.getSpecialite()+" votre contrat expirera le  "+ c.getDateFinContrat()+" merci de consulter l'adminstration" );
        }

    }


}



package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static tn.spring.springboot.entities.Niveau.*;

@Service
@AllArgsConstructor

public class EquipeServiceImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);

    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }


    @Override
    public Equipe getEquipeById(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(Long idEtudiant, Integer idDepart) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public int faireEvoluerEquipes() {
        List<Equipe> equipes=equipeRepository.findAll();
        List<Equipe> equipesJS=new ArrayList<Equipe>();

        for (Equipe e: equipes
             ) {
            if (e.getNiveau().equals(JUNIOR)||e.getNiveau().equals(SENIOR)){
                equipesJS.add(e);
            }

        }
        int nbEtudiantValide=0;

        for (Equipe e: equipesJS){
            if (e.getEtudiant().size()>=3){
                boolean etudiantValide=false;
                for (Etudiant etudiant: e.getEtudiant()) {
                    //list des contrats d'un etudiant
                    Set<Contrat> contrats =  etudiant.getContrat();
                    for (Contrat c: contrats){
                        Date todayDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

                        if ((todayDate.getTime()>c.getDateFinContrat().getTime())){
                         etudiantValide=true;

                        }
                        if (etudiantValide==true){
                            nbEtudiantValide=nbEtudiantValide+1;

                        }
                    }
                }
                }
            //evoluerEqiupe
            /*
            if (e.getEtudiant().size()<=nbEtudiantValide){
                switch (e.getNiveau()){
                    case JUNIOR:e.setNiveau(SENIOR);
                    equipeRepository.save(e);
                    break;
                    case SENIOR:e.setNiveau(EXPERT);
                    equipeRepository.save(e);
                    break;
                }
            }

             */
        }
        return nbEtudiantValide;



    }
}

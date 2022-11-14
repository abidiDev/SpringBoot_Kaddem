package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.*;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.repository.EtudiantRepository;
import tn.spring.springboot.repository.DepartementRepository;

import javax.transaction.Transactional;
import java.util.List;

//c'est une annotation qui permet spring d'instancier cette classe pour gérer le cycle de vie de l'app
@Service
@AllArgsConstructor

public class EtudiantServiceImp implements IEtudiantService{
    //injection du repository dans sercice
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    EquipeRepository equipeRepository;
    ContratRepository contratRepository;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        //save: si l'objet est persistant ell fait la modif snn elle l'ajoute
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {
       etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByPrenomEContains(String prenom) {
        return etudiantRepository.findEtudiantByPrenomEContains(prenom);
    }

    @Override
    public void updateEtudiantByOption(Option op, Long idEtudiant) {
         etudiantRepository.updateEtudiantByOption(op,idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Long idEtudiant, int idDepartement) {
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat=contratRepository.findById(idContrat).orElse(null);
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        etudiantRepository.save(e);
        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        equipe.getEtudiant().add(e);
        equipeRepository.save(equipe);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findEtudiantByDepartement(departementRepository.findById(idDepartement).orElse(null));
    }
}

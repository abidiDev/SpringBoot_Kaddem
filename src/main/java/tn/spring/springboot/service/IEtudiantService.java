package tn.spring.springboot.service;

import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Option;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(Long id);
    public Etudiant getEtudiantById(Long id);

    public Etudiant findEtudiantByPrenomEContains(String prenom);
    public     void updateEtudiantByOption(Option op , Long idEtudiant);
    public void assignEtudiantToDepartement(Long idEtudiant,int idDepartement);
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}

package tn.spring.springboot.service;

import tn.spring.springboot.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public List<Etudiant> getAllEtudiants();
    public Etudiant addEtudiant(Etudiant e);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(Long id);
    public Etudiant getEtudiantById(Long id);

    public Etudiant findEtudiantByPrenomEContains(String prenom);
}

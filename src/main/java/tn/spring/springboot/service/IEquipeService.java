package tn.spring.springboot.service;

import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Niveau;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getAllEquipes();
    public Equipe addEquipe(Equipe e);
    public Equipe updateEquipe(Equipe e);
    public void deleteEquipe(Integer id);
    public Equipe getEquipeById(Integer id);
    public List<Equipe> findEquipeByEtudiantIdEtudiant(Long idEtudiant);
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart (Long idEtudiant, Integer idDepart);
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);
    public  void deleteEquipeByNiveau( Niveau niveau);

}

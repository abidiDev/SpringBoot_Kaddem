package tn.spring.springboot.service;

import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getAllEquipes();
    public Equipe addEquipe(Equipe e);
    public Equipe updateEquipe(Equipe e);
    public void deleteEquipe(Integer id);
    public Equipe getEquipeById(Integer id);
}

package tn.spring.springboot.service;

import tn.spring.springboot.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipe {

    public List<DetailEquipe> getAllDetailEquipes();
    public DetailEquipe addDetailEquipe(DetailEquipe e);
    public DetailEquipe updateDetailEquipe(DetailEquipe e);
    public void deleteDetailDetailEquipe(Integer id);
    public DetailEquipe getDetailEquipeById(Integer id);
}

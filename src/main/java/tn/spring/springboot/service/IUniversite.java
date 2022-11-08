package tn.spring.springboot.service;

import tn.spring.springboot.entities.Universite;

import java.util.List;

public interface IUniversite {
    public List<Universite> getAllUniversites();
    public Universite addUniversite(Universite u);
    public Universite updateUniversite(Universite u);
    public  void  deleteUniversite(Integer id);
    public Universite getUniversiteById(Integer id);
    public void assignUniversiteToDepartement(int idUniv,int idDepartement);
}

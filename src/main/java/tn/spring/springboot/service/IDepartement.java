package tn.spring.springboot.service;

import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Option;

import java.util.List;

public interface IDepartement {
    public List<Departement> getAllDepartements();
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public void deleteDetailDepartement(Integer id);
    public Departement getDepartementById(Integer id);
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op);

}

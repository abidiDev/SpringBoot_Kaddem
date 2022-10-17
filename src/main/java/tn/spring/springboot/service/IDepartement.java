package tn.spring.springboot.service;

import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.DetailEquipe;

import java.util.List;

public interface IDepartement {
    public List<Departement> getAllDepartements();
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public void deleteDetailDepartement(Integer id);
    public Departement getDepartementById(Integer id);
}

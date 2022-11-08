package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.repository.DepartementRepository;
import tn.spring.springboot.repository.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteImpl implements IUniversite {
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(Integer id) {
         universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Integer id) {
        return universiteRepository.getReferenceById(id);
    }

    @Override
    public void assignUniversiteToDepartement(int idUniv, int idDepartement) {
        Universite universite=universiteRepository.findById(idUniv).orElse(null);
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }

}

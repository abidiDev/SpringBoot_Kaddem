package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Option;
import tn.spring.springboot.repository.DepartementRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DepartementImpl implements IDepartement{
    DepartementRepository departementRepository;
    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDetailDepartement(Integer id) {
         departementRepository.deleteById(id);
    }

    @Override
    public Departement getDepartementById(Integer id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }


}

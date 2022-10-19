package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.repository.IDepartementRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DepartementImpl implements IDepartement{
    IDepartementRepository departementRepository;
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
}

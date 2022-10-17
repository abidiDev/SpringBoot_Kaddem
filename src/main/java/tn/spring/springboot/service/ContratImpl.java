package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.repository.ContratRepository;

import java.util.List;

@Service
public class ContratImpl implements IContrat{
    @Autowired
    ContratRepository contratRepository;
    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteDetailContrat(Integer id) {
       contratRepository.deleteById(id);
    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }
}

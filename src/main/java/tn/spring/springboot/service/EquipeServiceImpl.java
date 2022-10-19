package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.EquipeRepository;
import tn.spring.springboot.repository.EtudiantRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class EquipeServiceImpl implements IEquipeService{
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);

    }

    @Override
    public void deleteEquipe(Integer id) {
        equipeRepository.deleteById(id);
    }


    @Override
    public Equipe getEquipeById(Integer id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(Long idEtudiant, Integer idDepart) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepart);
    }
}

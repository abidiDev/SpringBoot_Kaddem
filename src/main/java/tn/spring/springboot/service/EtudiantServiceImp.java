package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.repository.EtudiantRepository;

import java.util.List;

//c'est une annotation qui permet spring d'instancier cette classe pour gérer le cycle de vie de l'app
@Service
public class EtudiantServiceImp implements IEtudiantService{
    //injection du repository dans sercice
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        //save: si l'objet est persistant ell fait la modif snn elle l'ajoute
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {
       etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
}

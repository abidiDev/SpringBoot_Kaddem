package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.repository.DetailEquipeRepository;

import java.util.List;
@Service
public class DetailEquipeImpl implements IDetailEquipe{
    @Autowired
    DetailEquipeRepository detailEquipeRepository;
    @Override
    public List<DetailEquipe> getAllDetailEquipes() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    @Override
    public void deleteDetailDetailEquipe(Integer id) {
        detailEquipeRepository.deleteById(id);

    }

    @Override
    public DetailEquipe getDetailEquipeById(Integer id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }
}

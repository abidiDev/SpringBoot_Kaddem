package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.repository.DetailEquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class DetailEquipeImpl implements IDetailEquipe{
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

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }


}

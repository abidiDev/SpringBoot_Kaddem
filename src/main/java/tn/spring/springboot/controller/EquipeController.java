package tn.spring.springboot.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;

@RequestMapping("equipe")
@RestController
@AllArgsConstructor

public class EquipeController {
     IEquipeService iEquipeService;
    @GetMapping("/getAll")
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.getAllEquipes();
    }

    @PostMapping("/add")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe e){
        return iEquipeService.addEquipe(e);
    }
    @PutMapping("/update")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe E){
        return  iEquipeService.updateEquipe(E);
    }

    @DeleteMapping("/delete/{id}")
    public void getEquipe(@PathVariable Integer id) {
        iEquipeService.deleteEquipe(id);
    }
    @GetMapping("get/{id}")
    public Equipe getEquipeById(@PathVariable Integer id){
        return iEquipeService.getEquipeById(id);
    }
    @GetMapping("getByEtudiantId/{idEtudiant}")

    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable Long idEtudiant){
        return iEquipeService.findEquipeByEtudiantIdEtudiant(idEtudiant);
    }
    @GetMapping("getByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull/{idEtudiant}")

    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (@PathVariable Long idEtudiant){
        return  iEquipeService.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }
    @GetMapping("getByEtudiantIdEtudiantAndEtudiantDepartementIdDepart/{idEtudiant}/{idDepart}")

    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart( @PathVariable Long idEtudiant, @PathVariable Integer idDepart) {
       return iEquipeService.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant, idDepart);
    }

    @GetMapping("getByNiveauThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable Niveau niveau,@PathVariable String thematique) {
        return iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }
    @DeleteMapping("deleteEquipeByNiveau/{niveau}")

    public void deleteEquipeByNiveau(@PathVariable Niveau niveau) {
        iEquipeService.deleteEquipeByNiveau(niveau);
    }
    }

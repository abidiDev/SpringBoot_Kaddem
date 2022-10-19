package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.service.IDetailEquipe;

import java.util.List;

@RequestMapping("detailEquipe")
@RestController
@AllArgsConstructor

public class DetailEquipeController {
    IDetailEquipe iDetailEquipe;
    @GetMapping("/getAll")
    public List<DetailEquipe> getAllDetailEquipes(){
        return  iDetailEquipe.getAllDetailEquipes();
    }

    @PostMapping("/add")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e){
        return iDetailEquipe.addDetailEquipe(e);
    }
    @PutMapping("/update")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe E){
        return  iDetailEquipe.updateDetailEquipe(E);
    }

    @DeleteMapping("/delete/{id}")
    public void getDetailEquipe(@PathVariable Integer id) {
        iDetailEquipe.deleteDetailDetailEquipe(id);
    }
    @GetMapping("/get/{id}")
    public DetailEquipe getDetailEquipeById(@PathVariable Integer id){
        return iDetailEquipe.getDetailEquipeById(id);
    }

    @GetMapping("/findBythematique/{thematique}")

    public List<DetailEquipe> getByDetailEquipeThematique (@PathVariable("thematique") String thematique){
        return iDetailEquipe.findByThematiqueLike(thematique);
    }
}

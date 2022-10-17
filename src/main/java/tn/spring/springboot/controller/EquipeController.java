package tn.spring.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;

@RequestMapping("equipe")
@RestController
public class EquipeController {
    @Autowired
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
}

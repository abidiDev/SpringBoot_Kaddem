package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.service.IContrat;

import java.util.Date;
import java.util.List;

@RequestMapping("contrat")
@RestController
@AllArgsConstructor

public class ContratController {
    IContrat iContrat;

    @GetMapping("/getAll")
    public List<Contrat> getAllContrats(){
        return  iContrat.getAllContrats();
    }

    @PostMapping("/add")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat c){
        return iContrat.addContrat(c);
    }
    @PutMapping("/update")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat c){
        return  iContrat.updateContrat(c);
    }

    @DeleteMapping("/delete/{id}")
    public void getContrat(@PathVariable Integer id) {
        iContrat.deleteDetailContrat(id);
    }
    @GetMapping("get/{id}")
    public Contrat getContratById(@PathVariable Integer id){
        return iContrat.getContratById(id);
    }

    @PostMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    @ResponseBody
    public Contrat affectContratToEtudiant(  @RequestBody Contrat ce,@PathVariable String nomE,@PathVariable String prenomE) {
        return  iContrat.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")

    public List<Contrat> getChiffreAffaireEntreDeuxDate(@PathVariable Date startDate,@PathVariable Date endDate){
        return iContrat.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

    }

package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.service.IContrat;

import java.util.List;

@RequestMapping("contrat")
@RestController
public class ContratController {
    @Autowired
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


}

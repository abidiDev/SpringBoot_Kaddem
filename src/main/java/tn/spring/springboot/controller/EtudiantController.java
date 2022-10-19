package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.service.IEtudiantService;

import java.util.List;
@RequestMapping("etudiant")
@RestController
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService iEtudiantService;
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
    @GetMapping("/getAll")
    public List<Etudiant> getAllEtudiants(){
        return  iEtudiantService.getAllEtudiants();
    }

    @PostMapping("/add")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody  Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }
  @PutMapping("/update")
  @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant E){
        return  iEtudiantService.updateEtudiant(E);
    }

   @DeleteMapping("/delete/{id}")
    public void getEtudiant(@PathVariable Long id) {
        iEtudiantService.deleteEtudiant(id);
    }
    @GetMapping("get/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id){
        return iEtudiantService.getEtudiantById(id);
    }

    @GetMapping("getByPrenom/{prenom}")
    public Etudiant findEtudiantByPrenomEContains(@PathVariable String prenom){
       return iEtudiantService.findEtudiantByPrenomEContains(prenom);
    }
}

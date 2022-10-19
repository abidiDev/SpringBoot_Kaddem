package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.service.IDepartement;

import java.util.List;

@RequestMapping("departement")
@RestController
@AllArgsConstructor

public class DepartementController {
    IDepartement iDepartement;
    @GetMapping("/getAll")
    public List<Departement> getAllDepartements(){
        return  iDepartement.getAllDepartements();
    }

    @PostMapping("/add")
    @ResponseBody
    public Departement addDepartement(@RequestBody Departement d){
        return iDepartement.addDepartement(d);
    }
    @PutMapping("/update")
    @ResponseBody
    public Departement updateDepartement(@RequestBody Departement d){
        return  iDepartement.updateDepartement(d);
    }

    @DeleteMapping("/delete/{id}")
    public void getDepartement(@PathVariable Integer id) {
        iDepartement.deleteDetailDepartement(id);
    }
    @GetMapping("get/{id}")
    public Departement getDepartementById(@PathVariable Integer id){
        return iDepartement.getDepartementById(id);
    }

}

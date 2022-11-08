package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.service.IUniversite;

import java.util.List;

@RequestMapping("universites")
@RestController
@AllArgsConstructor
public class UniverciteController {
    IUniversite iUniversiteService;

    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites()
    {return iUniversiteService.getAllUniversites();}

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u)
    {return iUniversiteService.addUniversite(u);}

    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite u)
    {return iUniversiteService.updateUniversite(u);}

    @DeleteMapping("/removeUniversite/{idUniv}")
    public void removeUniversite(@PathVariable ("idUniv")Integer idUniv)
    { iUniversiteService.getUniversiteById(idUniv);}


    @PutMapping("assignUniversiteToDepartement/{idUniv}/{idDepart}")
    public void  assignUniversiteToDepartement(@PathVariable int idUniv , @PathVariable int idDepart )
    {iUniversiteService.assignUniversiteToDepartement(idUniv,idDepart);}

}

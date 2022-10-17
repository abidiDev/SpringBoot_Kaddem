package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Departement;

public interface IDepartementRepository extends JpaRepository<Departement,Integer> {
}

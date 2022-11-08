package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}

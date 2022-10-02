package tn.spring.springboot.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String nomUniv;
}

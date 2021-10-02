package br.com.gpqd.petshop.model;

import javax.persistence.*;

@Entity
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Cliente dono;

}

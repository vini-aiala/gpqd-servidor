package br.com.gpqd.petshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float preco;

    public Produto(String nome, Float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {

    }
}

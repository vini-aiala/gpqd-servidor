package br.com.gpqd.petshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Produto> produtos;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
}
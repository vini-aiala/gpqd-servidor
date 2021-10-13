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

    public Pedido(List<Produto> produtos, Cliente cliente, Funcionario funcionario) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pedido() {

    }
}

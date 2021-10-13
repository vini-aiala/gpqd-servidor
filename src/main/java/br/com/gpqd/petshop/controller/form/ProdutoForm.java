package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Produto;
import br.com.gpqd.petshop.repository.ProdutoRepository;

public class ProdutoForm {
    private String nome;
    private Float preco;

    public Produto build() {
        return new Produto(nome, preco);
    }

    public Produto update(Long id, ProdutoRepository produtoRepository) {
        Produto produto = produtoRepository.getById(id);
        produto.setNome(nome);
        produto.setPreco(preco);
        return produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}

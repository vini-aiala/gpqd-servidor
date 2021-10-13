package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Produto;

public class ProdutoForm {
    private String nome;
    private Float preco;

    public Produto build() {
        return new Produto(nome, preco);
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

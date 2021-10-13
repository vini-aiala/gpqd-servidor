package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Cliente;

public class ClienteForm {
    private String nome;

    private Cliente build() {
        return new Cliente(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

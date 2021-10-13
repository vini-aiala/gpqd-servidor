package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Funcionario;

public class FuncionarioForm {
    private String nome;
    private String cargo;

    public Funcionario build() {
        return new Funcionario(nome, cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

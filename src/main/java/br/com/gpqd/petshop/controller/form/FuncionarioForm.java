package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.repository.FuncionarioRepository;

public class FuncionarioForm {
    private String nome;
    private String cargo;

    public Funcionario build() {
        return new Funcionario(nome, cargo);
    }

    public Funcionario update(Long id, FuncionarioRepository funcionarioRepository) {
        Funcionario funcionario = funcionarioRepository.getById(id);
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        return funcionario;
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

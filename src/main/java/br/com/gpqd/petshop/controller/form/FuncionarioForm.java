package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.repository.FuncionarioRepository;

public class FuncionarioForm {
    private String nome;
    private String cargo;
    private String email;
    private String senha;

    public Funcionario build() {
        return new Funcionario(nome, cargo, email, senha);
    }

    public Funcionario update(Long id, FuncionarioRepository funcionarioRepository) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(IllegalAccessError::new);
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setEmail(email);
        funcionario.setSenha(senha);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

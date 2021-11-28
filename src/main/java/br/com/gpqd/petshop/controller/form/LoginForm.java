package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.FuncionarioRepository;

public class LoginForm {
    private String email;
    private String senha;

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

    public Funcionario buildFuncionario(FuncionarioRepository funcionarioRepository) {
        return funcionarioRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
    }

    public Cliente buildCliente(ClienteRepository clienteRepository) {
        return clienteRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
    }

}

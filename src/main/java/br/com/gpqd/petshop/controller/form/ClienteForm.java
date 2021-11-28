package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.repository.ClienteRepository;

public class ClienteForm {
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

    private String nome;
    private String email;
    private String senha;

    public Cliente build() {
        return new Cliente(nome, email, senha);
    }

    public Cliente update(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        assert cliente != null;
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

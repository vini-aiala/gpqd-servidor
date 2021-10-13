package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.repository.ClienteRepository;

public class ClienteForm {
    private String nome;

    public Cliente build() {
        return new Cliente(nome);
    }

    public Cliente update(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getById(id);
        cliente.setNome(nome);
        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

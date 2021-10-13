package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.model.Pet;
import br.com.gpqd.petshop.repository.ClienteRepository;

import javax.persistence.ManyToOne;

public class PetForm {
    private String nome;
    private Long donoId;

    public Pet build(ClienteRepository clienteRepository) {
        Cliente dono = clienteRepository.getById(donoId);
        return new Pet(nome, dono);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getDonoId() {
        return donoId;
    }

    public void setDonoId(Long donoId) {
        this.donoId = donoId;
    }
}

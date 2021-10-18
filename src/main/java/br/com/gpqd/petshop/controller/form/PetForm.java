package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.model.Pet;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.PetRepository;

public class PetForm {
    private String nome;
    private Long donoId;

    public Pet build(ClienteRepository clienteRepository) {
        Cliente dono = clienteRepository.findById(donoId).orElseThrow(IllegalArgumentException::new);
        return new Pet(nome, dono);
    }

    public Pet update (Long id, PetRepository petRepository, ClienteRepository clienteRepository) {
        Pet pet = petRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Cliente dono = clienteRepository.findById(donoId).orElseThrow(IllegalArgumentException::new);
        pet.setNome(nome);
        pet.setDono(dono);
        return pet;
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

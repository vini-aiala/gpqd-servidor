package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.PetForm;
import br.com.gpqd.petshop.model.Pet;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetRepository petRepository;
    private final ClienteRepository clienteRepository;

    public PetController(
            PetRepository petRepository,
            ClienteRepository clienteRepository
    ) {
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Pet> recoverPet() {
        return petRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pet getById(@PathVariable String id) {
        Optional<Pet> optional = petRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pet> createPets(PetForm form, UriComponentsBuilder uriBuilder) {
        Pet pet = form.build(clienteRepository);
        petRepository.save(pet);

        URI uri = uriBuilder.path("/pets/{id}").buildAndExpand(pet.getId()).toUri();
        return ResponseEntity.created(uri).body(pet);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody PetForm form) {
        Optional<Pet> optional = petRepository.findById(id);
        if (optional.isPresent()) {
            Pet pet = form.update(id, petRepository, clienteRepository);
            return ResponseEntity.ok(pet);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Pet> optional = petRepository.findById(id);
        if (optional.isPresent()) {
            petRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

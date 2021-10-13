package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.ClienteForm;
import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

     public ClienteController(
             ClienteRepository clienteRepository
     ) {
         this.clienteRepository = clienteRepository;
     }

    @GetMapping
    public List<Cliente> recoverCliente() {
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cliente getById(@PathVariable String id) {
        Optional<Cliente> optional = clienteRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> createClientes(ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.build();
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody ClienteForm form) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = form.update(id, clienteRepository);
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

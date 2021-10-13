package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.FuncionarioForm;
import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(
            FuncionarioRepository funcionarioRepository
    ) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> recoverFuncionario() {
        return funcionarioRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Funcionario getById(@PathVariable String id) {
        Optional<Funcionario> optional = funcionarioRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Funcionario> createFuncionarios(FuncionarioForm form, UriComponentsBuilder uriBuilder) {
        Funcionario funcionario = form.build();
        funcionarioRepository.save(funcionario);

        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody FuncionarioForm form) {
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        if (optional.isPresent()) {
            Funcionario funcionario = form.update(id, funcionarioRepository);
            return ResponseEntity.ok(funcionario);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Funcionario> optional = funcionarioRepository.findById(id);
        if (optional.isPresent()) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.repository.AgendamentoRepository;
import br.com.gpqd.petshop.controller.form.AgendamentoForm;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import br.com.gpqd.petshop.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;
    private final PetRepository petRepository;
    private final FuncionarioRepository funcionarioRepository;

    public AgendamentoController(
            AgendamentoRepository agendamentoRepository,
            PetRepository petRepository,
            FuncionarioRepository funcionarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.petRepository = petRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Agendamento> recoverAgendamento() {
        return agendamentoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Agendamento getById(@PathVariable String id) {
        Optional<Agendamento> optional = agendamentoRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Agendamento> createAgendamentos(AgendamentoForm form, UriComponentsBuilder uriBuilder) {
        Agendamento agendamento = form.build(petRepository, funcionarioRepository);
        agendamentoRepository.save(agendamento);

        URI uri = uriBuilder.path("/agendamentos/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(agendamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody AgendamentoForm form) {
        Optional<Agendamento> optional = agendamentoRepository.findById(id);
        if (optional.isPresent()) {
            Agendamento agendamento = form.update(id, agendamentoRepository, petRepository, funcionarioRepository);
            return ResponseEntity.ok(agendamento);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Agendamento> optional = agendamentoRepository.findById(id);
        if (optional.isPresent()) {
            agendamentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

package br.com.gpqd.petshop.controller.form;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.model.Pet;
import br.com.gpqd.petshop.repository.AgendamentoRepository;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import br.com.gpqd.petshop.repository.PetRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class AgendamentoForm {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime horario;
    private Long funcionarioId;
    private Long petId;

    public Agendamento build(PetRepository petRepository, FuncionarioRepository funcionarioRepository) throws IllegalArgumentException {
        Pet pet = petRepository.findById(petId).orElseThrow(IllegalArgumentException::new);
        assert pet != null;
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(IllegalArgumentException::new);
        return new Agendamento(horario, funcionario, pet);
    }

    public Agendamento update(Long id, AgendamentoRepository agendamentoRepository, PetRepository petRepository, FuncionarioRepository funcionarioRepository) throws IllegalArgumentException {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        assert agendamento != null;
        agendamento.setHorario(horario);
        agendamento.setFuncionario(funcionarioRepository.findById(funcionarioId).orElseThrow(IllegalArgumentException::new));
        agendamento.setPet(petRepository.findById(petId).orElseThrow(IllegalArgumentException::new));
        return agendamento;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}

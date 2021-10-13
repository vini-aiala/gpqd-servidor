package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.model.Pet;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import br.com.gpqd.petshop.repository.PetRepository;

import java.time.LocalDateTime;

public class AgendamentoForm {
    private LocalDateTime horario;
    private Long funcionarioId;
    private Long petId;

    public Agendamento build(PetRepository petRepository, FuncionarioRepository funcionarioRepository) {
        Pet pet = petRepository.getById(petId);
        Funcionario funcionario = funcionarioRepository.getById(funcionarioId);
        return new Agendamento(horario, funcionario, pet);
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

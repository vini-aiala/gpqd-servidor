package br.com.gpqd.petshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horario;
    @ManyToOne
    private Funcionario funcionario;
    @OneToOne
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Agendamento(LocalDateTime horario, Funcionario funcionario, Pet pet) {
        this.horario = horario;
        this.funcionario = funcionario;
        this.pet = pet;
    }

    public Agendamento() {

    }
}

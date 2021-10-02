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
}

package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}

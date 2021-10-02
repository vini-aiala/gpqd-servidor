package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
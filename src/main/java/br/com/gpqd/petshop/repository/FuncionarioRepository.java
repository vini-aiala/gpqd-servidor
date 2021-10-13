package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}

package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

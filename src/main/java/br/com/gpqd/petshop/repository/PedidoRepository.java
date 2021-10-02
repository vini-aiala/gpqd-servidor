package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

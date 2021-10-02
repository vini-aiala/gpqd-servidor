package br.com.gpqd.petshop.repository;

import br.com.gpqd.petshop.model.Agendamento;
import br.com.gpqd.petshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

package br.com.rogerbleggi.calcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rogerbleggi.calcard.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}

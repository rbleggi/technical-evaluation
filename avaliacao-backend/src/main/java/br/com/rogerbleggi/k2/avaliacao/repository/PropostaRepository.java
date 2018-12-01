package br.com.rogerbleggi.k2.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rogerbleggi.k2.avaliacao.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}

package br.com.rogerbleggi.k2.avaliacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rogerbleggi.k2.avaliacao.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

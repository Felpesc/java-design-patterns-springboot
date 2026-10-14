package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Este arquivo é um Repository do Spring Data
 * que cria automaticamente todas as operações de banco de dados
 * (como salvar, buscar, atualizar e deletar) para a entidade Cliente usando o tipo do ID (Long),
 * sem a necessidade de escrever código SQL manualmente.
 */


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
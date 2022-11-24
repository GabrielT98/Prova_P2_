package br.edu.universidadedevassouras.SCP.Repository;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    Optional<Pessoa> findByUsername(String userName);
}

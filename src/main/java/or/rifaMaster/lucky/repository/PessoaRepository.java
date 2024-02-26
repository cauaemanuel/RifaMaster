package or.rifaMaster.lucky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import or.rifaMaster.lucky.Entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	Pessoa findByNome(String nome);
}

package or.rifaMaster.lucky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import or.rifaMaster.lucky.Entity.RifaMaster;

public interface RifaRepository extends JpaRepository<RifaMaster, Integer>{

	RifaMaster findByNumb(Integer numb);
}

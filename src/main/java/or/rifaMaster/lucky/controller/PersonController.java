package or.rifaMaster.lucky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import or.rifaMaster.lucky.Entity.Pessoa;
import or.rifaMaster.lucky.Entity.RifaMaster;
import or.rifaMaster.lucky.dto.PessoaDTO;
import or.rifaMaster.lucky.services.ServiceRIfa;

@RestController
@RequestMapping("/lucky")
public class PersonController {

	@Autowired
	private ServiceRIfa rifa;
	
	@GetMapping
	public List<RifaMaster> getAllRifa(){
	
		return rifa.getAllRifa();
	}
	
	@GetMapping("/get")
	public Integer TamanhoRifa() {
		return rifa.tamanhoRifa();
	}
	
	@GetMapping("/sorteio")
	public RifaMaster sortear() {
		return rifa.sortear();
	}
	
	@PostMapping("/lenght")
	public ResponseEntity<String> criarRifa(@RequestBody Integer it) {
	    rifa.Criarrifa(it);
	    return ResponseEntity.ok("Rifa criada com sucesso.");
	}

	
	@DeleteMapping("/delete")
	public void apagarRifa() {
		rifa.apagarRifa();
	}
	
	@PostMapping("/")
	public Pessoa salvarPessoa(@RequestBody PessoaDTO ps ) {
		return rifa.salvarPessoa(ps.getIdade(), ps.getNome(), ps.getNum(), ps.getVed());
	}
}


package or.rifaMaster.lucky.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.rifaMaster.lucky.Entity.Pessoa;
import or.rifaMaster.lucky.Entity.RifaMaster;
import or.rifaMaster.lucky.exception.NumInvalidException;
import or.rifaMaster.lucky.repository.PessoaRepository;
import or.rifaMaster.lucky.repository.RifaRepository;

@Service
public class ServiceRIfa {

	@Autowired
	private PessoaRepository pessoarepository;
	
	@Autowired
    private RifaRepository rifarepository;
   
	private Integer tamanhorifa ;
	
	public List<RifaMaster> getAllRifa(){
		return rifarepository.findAll();	
	}
	
	public RifaMaster sortear() {
	    List<RifaMaster> ent = rifarepository.findAll();

	    if (!ent.isEmpty()) {
	        Collections.shuffle(ent);
	        return ent.get(0);
	    } else {
	        // 
	        throw new NumInvalidException("Lista vazia!"); 
	    }
	}

	
	public void apagarRifa() {
		rifarepository.deleteAll();
		pessoarepository.deleteAll();
	}
	
	public Pessoa salvarPessoa( Integer idade,String nome, Integer num, String ved ) {
					
			if(num == null || num > tamanhorifa || rifarepository.findByNumb(num) != null) {
				throw new NumInvalidException("Numero invalido"); 
			}else {
				Pessoa ps = pessoarepository.findByNome(nome);
		        if (ps != null) {
		            RifaMaster rf = new RifaMaster(num, ps, ved);
		            rifarepository.save(rf);
		            return ps;
				}else {
					
					RifaMaster rf = new RifaMaster();
					ps = new Pessoa(idade, nome, rf);
					rf.setComprador(ps);
					rf.setNumb(num);
					rf.setVendedor(ved);
					pessoarepository.save(ps);
				    rifarepository.save(rf);
				    return ps;				
				}				
		    }	
	}
	
	public void Criarrifa(Integer it) {
		this.tamanhorifa = it;
		apagarRifa();
	}
	
	public Integer tamanhoRifa() {
		return tamanhorifa;
	}
	
}

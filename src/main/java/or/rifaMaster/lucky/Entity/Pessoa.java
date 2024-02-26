package or.rifaMaster.lucky.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    private Integer idade;
    
    private String nome;
    
    @OneToMany(mappedBy = "comprador")
    private List<RifaMaster> num = new ArrayList<>();
     
    public Pessoa() {
    	
    }

	public Pessoa(Integer idade, String nome,RifaMaster num) {
		super();
		this.idade = idade;
		this.nome = nome;
		this.num.add(num);
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
    
   
}

package or.rifaMaster.lucky.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RifaMaster {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numb;
	
	@ManyToOne
	@JoinColumn(name = "comprador_id")
	private Pessoa comprador;

	private String vendedor;
	
	public RifaMaster() {
		
	}

	public RifaMaster(Integer numb, Pessoa comprador, String vendedor) {
		super();
		this.numb = numb;
		this.comprador = comprador;
		this.vendedor = vendedor;
	}

	public Integer getNumb() {
		return numb;
	}

	public void setNumb(Integer numb) {
		this.numb = numb;
	}

	public Pessoa getComprador() {
		return comprador;
	}

	public void setComprador(Pessoa comprador) {
		this.comprador = comprador;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	
}

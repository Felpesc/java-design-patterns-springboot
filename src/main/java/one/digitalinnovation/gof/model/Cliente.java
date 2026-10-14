package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

	@Id // Indica que este atributo é a chave primária da tabela no banco de dados. (Long id)
	@GeneratedValue(strategy = GenerationType.AUTO) // Define que o valor do ID será gerado automaticamente, deixando o Hibernate escolher a melhor estratégia.
	private Long id; // Declara a variável privada 'id' do tipo numérico Long, que identificará unicamente cada registro.
	private String nome;
	@ManyToOne //Um endereço pode esta para varios Clientes
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

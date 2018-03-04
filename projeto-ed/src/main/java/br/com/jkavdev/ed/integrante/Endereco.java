package br.com.jkavdev.ed.integrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String logradouro;

	@Column
	private String numero;

	@Column
	private String cidade;

	@Column
	private String uf;

	@Column
	private String cep;

	@Column
	private String complemento;

	public Endereco(String logradouro, String numero, String cidade, String uf, String cep, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco logradouro=" + logradouro + ", numero=" + numero + ", cep=" + cep;
	}
	
}

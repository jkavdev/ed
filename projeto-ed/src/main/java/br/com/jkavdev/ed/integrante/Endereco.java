package br.com.jkavdev.ed.integrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

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
	
	//TODO tem que rever, esta dando erro ao atribui um construtor privado
	//solucoes
		//aumentar a visibilidade do construtor
		//definir o relacionamento como EAGER
	protected Endereco() {}

	public Endereco(String logradouro, String numero, String cidade, String uf, String cep, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
	}
	
	public static Endereco empty() {
		Endereco endereco = new Endereco();
		endereco.logradouro = "";
		endereco.numero = "";
		endereco.cidade = "";
		endereco.uf = "";
		endereco.cep = "";
		endereco.complemento = "";
		return endereco;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public String getCep() {
		return cep;
	}
	public String getComplemento() {
		return complemento;
	}

	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("logradouro", logradouro)
				.add("numero", numero)
				.add("cidade", cidade)
				.add("uf", uf)
				.add("cep", cep)
				.add("complemento", complemento).toString();
	}
	
}

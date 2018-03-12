package br.com.jkavdev.groups.evento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.MoreObjects;

@Entity
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String logradouro;

	private String numero;

	private String cidade;

	@Enumerated(EnumType.STRING)
	private UF uf;

	private String cep;

	private String complemento;
	
	private Endereco() {}
	
	public Endereco(String logradouro, String numero, String cidade, UF uf, String cep, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
	}
	
	public static Endereco empty() {
		Endereco empty = new Endereco();
		empty.logradouro = "";
		empty.numero = "";
		empty.cidade = "";
		empty.uf = UF.NONE;
		empty.cep = "";
		empty.complemento = "";
		return empty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

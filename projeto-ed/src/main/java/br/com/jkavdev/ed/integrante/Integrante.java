package br.com.jkavdev.ed.integrante;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.google.common.base.MoreObjects;

import br.com.jkavdev.ed.grupointegrante.GrupoIntegrante;

@Entity
@Table(name = "integrante")
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private Integer idade;

	@NaturalId
	@Column(unique = true)
	private String email;

	@Column
	private String celular;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco = Endereco.empty();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "complemento_id")
	private Complemento complemento = Complemento.empty();

	@OneToMany(mappedBy = "integrante", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<GrupoIntegrante> grupos = Collections.emptySet();
	
	private Integrante() {}

	public Integrante(String nome, Integer idade, String email, String celular, Endereco endereco, Complemento complemento) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.celular = celular;
		this.endereco = endereco;
		this.complemento = complemento;
		this.grupos = Collections.emptySet();
	}
	
	public static Integrante empty() {
		Integrante integrante = new Integrante();
		integrante.nome = "";
		integrante.email = "";
		integrante.celular = "";
		integrante.idade = 0;
		integrante.endereco = Endereco.empty();
		integrante.complemento = Complemento.empty();
		integrante.grupos = Collections.emptySet();
		return integrante;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCelular() {
		return celular;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public Complemento getComplemento() {
		return complemento;
	}
	public Collection<GrupoIntegrante> getGrupos() {
		return grupos;
	}

	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("nome", nome)
				.add("idade", idade)
				.add("email", email)
				.add("celular", celular).toString();
	}

}

package br.com.jkavdev.ed.integrante;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@Column(unique = true)
	private String email;

	@Column
	private String celular;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "complemento_id")
	private Complemento complemento;

	@OneToMany(mappedBy = "integrante", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<GrupoIntegrante> grupos;

}

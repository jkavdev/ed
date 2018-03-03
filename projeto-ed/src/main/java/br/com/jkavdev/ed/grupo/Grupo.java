package br.com.jkavdev.ed.grupo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.jkavdev.ed.grupointegrante.GrupoIntegrante;
import br.com.jkavdev.ed.statusgrupo.StatusGrupo;

@Entity
@Table(name = "grupo")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@ManyToOne
	@JoinColumn(name = "status_grupo_id")
	private StatusGrupo statusGrupo;

	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<GrupoIntegrante> integrantes;

}

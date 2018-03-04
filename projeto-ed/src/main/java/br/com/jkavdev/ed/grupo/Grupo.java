package br.com.jkavdev.ed.grupo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

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
import br.com.jkavdev.ed.integrante.Integrante;
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

	public Grupo(String nome, StatusGrupo statusGrupo) {
		this.nome = nome;
		this.statusGrupo = statusGrupo;
	}

	public Long getId() {
		return id;
	}
	public Collection<GrupoIntegrante> getIntegrantes() {
		return Collections.unmodifiableCollection(integrantes);
	}

	public void adicionar(Integrante integrante) {
		Objects.requireNonNull(integrante);

		if (integrantes == null)
			integrantes = new HashSet<>();

		GrupoIntegrante gi = new GrupoIntegrante(this, integrante);
		integrantes.add(gi);
		integrante.getGrupos().add(gi);
	}

	public void remover(Integrante integrante) {
		Objects.requireNonNull(integrante);

		if (integrantes == null || integrantes.isEmpty())
			throw new UnsupportedOperationException("Grupo não contem integrantes");

		for (Iterator<GrupoIntegrante> iterator = integrantes.iterator(); iterator.hasNext();) {
			GrupoIntegrante gi = iterator.next();

			if (gi.getGrupo().equals(this) && gi.getIntegrante().equals(integrante)) {
				iterator.remove();
				gi.getIntegrante().getGrupos().remove(gi);
				gi.reset();
			}
		}
	}
	
	public boolean contemPessoa(Integrante integrante, Integrante... integrantes) {
		return this.integrantes.stream()
					.map(GrupoIntegrante::getIntegrante)
					.anyMatch(i -> i.equals(integrante));
	}
	public boolean naoContemPessoa(Integrante integrante, Integrante... integrantes) {
		return !contemPessoa(integrante, integrantes);
	}

	@Override
	public String toString() {
		return "Grupo nome=" + nome + ", " + statusGrupo;
	}

}

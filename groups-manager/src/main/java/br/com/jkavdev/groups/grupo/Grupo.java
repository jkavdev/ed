package br.com.jkavdev.groups.grupo;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.google.common.base.MoreObjects;

import br.com.jkavdev.groups.evento.Evento;
import br.com.jkavdev.groups.integrante.Integrante;

@Entity
public class Grupo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String igreja;
	
	@ManyToMany
	@JoinTable(
			name = "grupo_integrante",
			joinColumns=@JoinColumn(name="grupo_id"),
			inverseJoinColumns=@JoinColumn(name="integrante_id"))
	private Collection<Integrante> integrantes = Collections.emptySet();
	
	@OneToMany(mappedBy = "grupo")
	private Collection<Evento> eventos = Collections.emptySet();
	
	@OneToMany(mappedBy = "grupo")
	private Collection<Noticia> noticias = Collections.emptySet();
	
	private Grupo() {}
	
	public Grupo(Long id, String nome, String igreja) {
		this.id = id;
		this.nome = nome;
		this.igreja = igreja;
	}

	public static Grupo empty() {
		Grupo empty = new Grupo();
		empty.nome = "";
		empty.igreja = "";
		return empty;
	}
	
	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("nome", nome)
				.add("igreja", igreja).toString();
	}
}

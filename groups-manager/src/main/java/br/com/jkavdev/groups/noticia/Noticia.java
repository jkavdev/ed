package br.com.jkavdev.groups.noticia;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.google.common.base.MoreObjects;

import br.com.jkavdev.groups.grupo.Grupo;

@Entity
public class Noticia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	@ElementCollection
	@JoinTable(
			name = "topico_noticia",
			joinColumns=@JoinColumn(name = "noticia_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "topico", nullable = false)
	private Collection<Topico> topicos = Collections.emptySet();
	
	private String corpo;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	private Noticia() {}

	public Noticia(String titulo, Collection<Topico> topicos, String corpo, Grupo grupo) {
		this.titulo = titulo;
		this.topicos = topicos;
		this.corpo = corpo;
		this.grupo = grupo;
	}
	
	public static Noticia empty() {
		Noticia empty = new Noticia();
		empty.titulo = "";
		empty.corpo = "";
		empty.grupo = Grupo.empty();
		return empty;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("titulo", titulo).toString();
	}
	
}

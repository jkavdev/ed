package br.com.jkavdev.groups.evento;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.google.common.base.MoreObjects;

import br.com.jkavdev.groups.grupo.Grupo;

@Entity
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalTime data;
	
	private String descricao;
	
	private String motivo;
	
	private BigDecimal valor;
	
	@Column(name = "lotacao_maxima")
	private int lotacaoMaxima;
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	private Evento() {}

	public Evento(LocalTime data, String descricao, String motivo, BigDecimal valor, int lotacaoMaxima,
			Endereco endereco, Grupo grupo) {
		this.data = data;
		this.descricao = descricao;
		this.motivo = motivo;
		this.valor = valor;
		this.lotacaoMaxima = lotacaoMaxima;
		this.endereco = endereco;
		this.grupo = grupo;
	}
	
	public static Evento empty() {
		Evento empty = new Evento();
		empty.data = LocalTime.now();
		empty.descricao = "";
		empty.motivo = "";
		empty.valor = BigDecimal.ZERO;
		empty.lotacaoMaxima = 0;
		empty.endereco = Endereco.empty();
		empty.grupo = Grupo.empty();
		return empty;
	}
	
	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("data", data)
				.add("descricao", descricao)
				.add("valor", valor)
				.add("lotacaoMaxima", lotacaoMaxima).toString();
	}

}

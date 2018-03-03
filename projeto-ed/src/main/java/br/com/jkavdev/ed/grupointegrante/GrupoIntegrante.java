package br.com.jkavdev.ed.grupointegrante;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import br.com.jkavdev.ed.grupo.Grupo;
import br.com.jkavdev.ed.integrante.Integrante;

@Entity
@Table(name = "grupo_integrante")
public class GrupoIntegrante {

	@EmbeddedId
	private GrupoIntegrantePK id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("grupo_id")
	private Grupo grupo;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("integrante_id")
	private Integrante integrante;

	@Column(name = "data_inclusao")
	private LocalDate dataInclusao;

}

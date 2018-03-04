package br.com.jkavdev.ed.grupointegrante;

import java.time.LocalDate;
import java.util.Objects;

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
	private LocalDate dataInclusao = LocalDate.now();

	public GrupoIntegrante(Grupo grupo, Integrante integrante) {
		Objects.requireNonNull(grupo);
		Objects.requireNonNull(integrante);

		this.grupo = grupo;
		this.integrante = integrante;
		this.id = new GrupoIntegrantePK(grupo.getId(), integrante.getId());
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	public Integrante getIntegrante() {
		return integrante;
	}
	public LocalDate getDataInclusao() {
		return dataInclusao;
	}
	
	public void reset() {
		grupo = null;
		integrante = null;
		id = null;
	}

	@Override
	public String toString() {
		return "GrupoIntegrante " + grupo + ", " + integrante + ", dataInclusao=" + dataInclusao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grupo, integrante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        
        GrupoIntegrante that = (GrupoIntegrante) obj;
        
        return Objects.equals(grupo, that.grupo) && 
               Objects.equals(integrante, that.integrante);
	}

}

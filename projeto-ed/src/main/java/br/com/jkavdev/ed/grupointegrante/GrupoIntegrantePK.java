package br.com.jkavdev.ed.grupointegrante;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GrupoIntegrantePK implements Serializable {

	private static final long serialVersionUID = 2122328719687965597L;

	@Column(name = "grupo_id")
	private Long grupo;

	@Column(name = "integrante_id")
	private Long integrante;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((integrante == null) ? 0 : integrante.hashCode());
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
		GrupoIntegrantePK other = (GrupoIntegrantePK) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (integrante == null) {
			if (other.integrante != null)
				return false;
		} else if (!integrante.equals(other.integrante))
			return false;
		return true;
	}
	
}

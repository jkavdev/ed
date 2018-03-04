package br.com.jkavdev.ed.grupointegrante;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GrupoIntegrantePK implements Serializable {

	private static final long serialVersionUID = 2122328719687965597L;

	@Column(name = "grupo_id")
	private Long grupo;

	@Column(name = "integrante_id")
	private Long integrante;
	
	private GrupoIntegrantePK() {}
	
	public GrupoIntegrantePK(Long grupo, Long integrante) {
		this.grupo = grupo;
		this.integrante = integrante;
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
        
        GrupoIntegrantePK that = (GrupoIntegrantePK) obj;
        
        return Objects.equals(grupo, that.grupo) && 
               Objects.equals(integrante, that.integrante);
	}
	
}

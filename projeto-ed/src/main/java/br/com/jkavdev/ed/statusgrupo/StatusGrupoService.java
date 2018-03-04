package br.com.jkavdev.ed.statusgrupo;

import java.io.Serializable;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.hibernate.service.spi.Manageable;

import br.com.jkavdev.ed.exceptions.EDException;

@Stateless
public class StatusGrupoService implements Serializable {
	
	private static final long serialVersionUID = -8174033469079395973L;
	
	@Inject
	private StatusGrupoRepository statusGrupoRepository;

	public void salvar(StatusGrupo statusGrupo) throws EDException {
		try {
			if(fetchStatusGrupo(statusGrupo.getNome()).isPresent())
				throw new EDException("Já existe Status Grupo com o nome: " + statusGrupo.getNome());
			
			statusGrupoRepository.salvar(statusGrupo);
		} catch (PersistenceException e) {
			throw new EDException(e);
		}
	}
	
	public Optional<StatusGrupo> fetchStatusGrupo(String nome) {
		return statusGrupoRepository.porNome(nome);
	}

	public StatusGrupo peloId(Long id) {
		return statusGrupoRepository.peloId(id);
	}

}

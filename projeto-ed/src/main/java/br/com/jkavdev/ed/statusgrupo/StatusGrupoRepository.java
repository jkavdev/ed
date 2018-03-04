package br.com.jkavdev.ed.statusgrupo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class StatusGrupoRepository implements Serializable {

	private static final long serialVersionUID = 4084094859394628477L;

	private static final Logger LOGGER = Logger.getLogger(StatusGrupoRepository.class);

	@PersistenceContext
	private EntityManager manager;

	public List<StatusGrupo> allStatusGrupos() {
		List<StatusGrupo> resultados = manager.createQuery("from StatusGrupo", StatusGrupo.class).getResultList();
		return resultados;
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salvar(StatusGrupo statusGrupo) {
		manager.persist(statusGrupo);
	}
	
	public Optional<StatusGrupo> porNome(String nome) {
		try {
			return Optional.ofNullable(manager.createQuery("from StatusGrupo where nome = :nome", StatusGrupo.class)
													.setParameter("nome", nome)
													.getSingleResult());
		} catch (PersistenceException e) {
			return Optional.empty();
		}
	}

	public StatusGrupo peloId(Long id) {
		return manager.find(StatusGrupo.class, id);
	}

}

package br.com.jkavdev.ed.statusgrupo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import br.com.jkavdev.ed.exceptions.EDException;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class StatusGrupoService implements Serializable {

	private static final long serialVersionUID = -8174033469079395973L;

	private static final Logger LOGGER = Logger.getLogger(StatusGrupoService.class);

	@PersistenceContext
	private EntityManager manager;

	public List<StatusGrupo> todosStatus() {
		LOGGER.info("todosStatus........");
		return manager.createQuery("FROM StatusGrupo", StatusGrupo.class).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(StatusGrupo statusGrupo) throws EDException {
		if(statusGrupo.getId() == null) {
			inserir(statusGrupo);
		} else {
			atualizar(statusGrupo);
		}
	}

	private void inserir(StatusGrupo statusGrupo) {
		if(porNome(statusGrupo.getNome()).isPresent())
				throw new EDException("Nome já utilizado: " + statusGrupo.getNome() + ", escolha outro nome");
		
		manager.persist(statusGrupo);
	}
	
	private void atualizar(StatusGrupo statusGrupo) {
		manager.merge(statusGrupo);
	}

	public Optional<StatusGrupo> porNome(String nome) {
		LOGGER.info("porNome........");
		return manager.createQuery("FROM StatusGrupo WHERE nome = :nome", StatusGrupo.class).setParameter("nome", nome)
				.getResultList().stream().findFirst();
	}

	public StatusGrupo peloId(Long id) {
		LOGGER.info("peloId........");
		return manager.find(StatusGrupo.class, id);
	}

}

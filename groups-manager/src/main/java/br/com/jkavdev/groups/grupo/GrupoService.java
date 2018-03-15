package br.com.jkavdev.groups.grupo;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class GrupoService {

	@PersistenceContext
	private EntityManager manager;

	public List<Grupo> todosGrupos() {
		return manager.createQuery("From Grupo", Grupo.class).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionar(Grupo grupo) {
		manager.persist(grupo);
	}

}

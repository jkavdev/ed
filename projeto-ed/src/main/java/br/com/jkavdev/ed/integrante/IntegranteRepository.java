package br.com.jkavdev.ed.integrante;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class IntegranteRepository implements Serializable {

	@PersistenceContext
	private EntityManager manager;

	public List<Integrante> todosIntegrantes() {
		return manager.createQuery("from Integrante", Integrante.class).getResultList();
	}
	public Integrante integranteComEndereco(Long id) {
		return manager.createQuery("select i from Integrante i join fetch i.endereco where i.id = :id", Integrante.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	public Integrante integranteComComplemento(Long id) {
		return manager.createQuery("select i from Integrante i join fetch i.complemento where i.id = :id", Integrante.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}

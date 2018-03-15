package br.com.jkavdev.groups.noticia;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class NoticiaService {

	@PersistenceContext
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionar(Noticia noticia) {
		manager.persist(noticia);
	}

}

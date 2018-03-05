package br.com.jkavdev.ed.integrante;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class IntegranteService implements Serializable {

	@Inject
	private IntegranteRepository integranteRepository;

	public List<Integrante> todosIntegrantes() {
		return integranteRepository.todosIntegrantes();
	}

	public Integrante integranteComEndereco(Long id) {
		return integranteRepository.integranteComEndereco(id);
	}

	public Integrante integranteComComplemento(Long id) {
		return integranteRepository.integranteComComplemento(id);
	}

}

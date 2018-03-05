package br.com.jkavdev.ed.integrante;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@ViewScoped
public class IntegranteBean implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(IntegranteBean.class);

	@Inject
	private IntegranteService integranteService;

	private List<Integrante> integrantes = Collections.emptyList();

	private Integrante integrante = Integrante.empty();

	@PostConstruct
	public void aoIniciar() {
		LOGGER.info("================= iniciando " + this);
	}

	public void pesquisar() {
		integrantes = integranteService.todosIntegrantes();
		LOGGER.info(integrantes);
	}

	public void integranteComEndereco() {
		integrante = integranteService.integranteComEndereco(integrante.getId());
	}

	public void integranteComComplemento() {
		integrante = integranteService.integranteComComplemento(integrante.getId());
	}

	public void reset() {
		integrantes = Collections.emptyList();
	}

	public List<Integrante> getIntegrantes() {
		return integrantes;
	}
	public Integrante getIntegrante() {
		return integrante;
	}
	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

}

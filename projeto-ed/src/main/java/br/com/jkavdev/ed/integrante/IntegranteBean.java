package br.com.jkavdev.ed.integrante;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.jkavdev.ed.integrante.form.IntegranteForm;

@Named
@ViewScoped
public class IntegranteBean implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(IntegranteBean.class);

	@Inject
	private IntegranteService integranteService;

	private List<Integrante> integrantes = Collections.emptyList();

	private Integrante integrante = Integrante.empty();
	
	private IntegranteForm form = IntegranteForm.empty();
	
	private boolean alergico = false;
	private boolean medicamento = false;

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
	
	public void salvar() {
		LOGGER.info(form);
		FacesMessage msg = new FacesMessage("Successful", "Welcome :" + form.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void reset() {
		integrantes = Collections.emptyList();
		form = IntegranteForm.empty();
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
	public IntegranteForm getForm() {
		return form;
	}
	public void setForm(IntegranteForm form) {
		this.form = form;
	}
	public List<UF> getUFs(){
		return Arrays.asList(UF.values());
	}
	public boolean isAlergico() {
		LOGGER.info(alergico);
		return alergico;
	}
	public void setAlergico(boolean alergico) {
		LOGGER.info(alergico);
		this.alergico = alergico;
	}
	public boolean isMedicamento() {
		LOGGER.info(medicamento);
		return medicamento;
	}
	public void setMedicamento(boolean medicamento) {
		LOGGER.info(medicamento);
		this.medicamento = medicamento;
	}

}

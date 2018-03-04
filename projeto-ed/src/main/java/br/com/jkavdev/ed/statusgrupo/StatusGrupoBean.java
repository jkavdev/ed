package br.com.jkavdev.ed.statusgrupo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@ViewScoped
public class StatusGrupoBean implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(StatusGrupoRepository.class);

	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	@Inject
	private StatusGrupoService statusGrupoService;

	private List<StatusGrupo> statusGrupos = Collections.emptyList();

	private StatusGrupo statusGrupo = StatusGrupo.empty();

	@PostConstruct
	public void aoIniciar() {
		LOGGER.info("================= iniciando " + this);
	}

	public void salvar() {
		try {
			statusGrupoService.salvar(statusGrupo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Status Grupo salvo!", "Status Grupo salvo!"));
			statusGrupo = StatusGrupo.empty();
		} catch (Exception e) {
			statusGrupo = StatusGrupo.empty();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getCause().getMessage(), e.getCause().getMessage()));
		}
	}

	public void pesquisar() {
		statusGrupos = statusGrupoRepository.allStatusGrupos();
	}

	public void limparForm() {
		statusGrupo = StatusGrupo.empty();
		statusGrupos = Collections.emptyList();
	}

	public List<StatusGrupo> getStatusGrupos() {
		return statusGrupos;
	}

	public StatusGrupo getStatusGrupo() {
		return statusGrupo;
	}

	public void setStatusGrupo(StatusGrupo statusGrupo) {
		this.statusGrupo = statusGrupo;
	}

}

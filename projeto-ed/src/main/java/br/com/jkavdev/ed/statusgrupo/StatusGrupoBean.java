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

import br.com.jkavdev.ed.exceptions.EDException;

@Named
@ViewScoped
public class StatusGrupoBean implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(StatusGrupoBean.class);

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
		} catch (EDException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), e.getMessage()));
		}
	}

	public void pesquisar() {
		statusGrupos = statusGrupoService.todosStatus();
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

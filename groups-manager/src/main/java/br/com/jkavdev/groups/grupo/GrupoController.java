package br.com.jkavdev.groups.grupo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class GrupoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private GrupoService grupoService;

	private List<Grupo> grupos = Collections.emptyList();
	
	private Grupo grupo = Grupo.empty();
	private Grupo grupoSelecionado = Grupo.empty();

	public void adicionar() {
		grupoService.adicionar(grupo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "adicionado com sucesso!", "Info"));
		grupo = Grupo.empty();
	}
	
	public void buscar() {
		grupos = grupoService.todosGrupos();
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}
	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}
	public boolean isApresentarAcoes() {
		return !grupos.isEmpty();
	}

}

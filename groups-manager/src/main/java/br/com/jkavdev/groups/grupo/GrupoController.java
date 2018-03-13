package br.com.jkavdev.groups.grupo;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class GrupoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Grupo grupo = Grupo.empty();

	public void adicionar() {
		System.out.println(grupo);
	}

	public Grupo getGrupo() {
		return grupo;
	}

}

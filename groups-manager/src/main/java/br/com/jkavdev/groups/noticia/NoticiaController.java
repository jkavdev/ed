package br.com.jkavdev.groups.noticia;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NoticiaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private NoticiaService noticiaService;

	private Noticia noticia = Noticia.empty();

	public void adicionar() {
		noticiaService.adicionar(noticia);
	}

	public Noticia getNoticia() {
		System.out.println(noticia);
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		System.out.println(noticia);
		this.noticia = noticia;
	}

}

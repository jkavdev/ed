package br.com.jkavdev.groups.noticia;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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
	
	private Topico[] topicosA;

	public void adicionar() {
		noticia.adicionar(topicosA);
		System.out.println(noticia.getTopicos());
	}

	public List<Topico> getTopicos(){
		return Arrays.asList(Topico.values());
	}
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public Topico[] getTopicosA() {
		return topicosA;
	}
	public void setTopicosA(Topico[] topicosA) {
		this.topicosA = topicosA;
	}

}

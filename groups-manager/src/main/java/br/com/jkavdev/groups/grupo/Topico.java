package br.com.jkavdev.groups.grupo;

public enum Topico {
	
	MUNDO("Mundo"),
	NEGOCIOS("Negócios"),
	CIENCIA_TECNOLOGIA("Ciencia/Tecnologia"),
	ENTRETERIMENTO("Entreterimento"),
	ESPORTE("Esporte"),
	SAUDE("Saúde"),
	OUTROS("Outros");
	
	private String descricao;

	private Topico(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

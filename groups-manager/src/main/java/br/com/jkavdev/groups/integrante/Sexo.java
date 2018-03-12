package br.com.jkavdev.groups.integrante;

public enum Sexo {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;

	private Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

package br.com.jkavdev.ed.integrante.form;

import org.hibernate.validator.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EnderecoForm {

	@NotBlank
	private String logradouro;

	@NotBlank
	private String numero;

	@NotBlank
	private String cidade;

	@NotBlank
	private String uf;

	@NotBlank
	private String cep;

	@NotBlank
	private String complemento;
	
	public static EnderecoForm empty() {
		EnderecoForm endereco = new EnderecoForm();
		endereco.logradouro = "";
		endereco.numero = "";
		endereco.cidade = "";
		endereco.uf = "";
		endereco.cep = "";
		endereco.complemento = "";
		return endereco;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Override
	public String toString() {
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

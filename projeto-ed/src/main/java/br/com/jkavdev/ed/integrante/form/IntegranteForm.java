package br.com.jkavdev.ed.integrante.form;


import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class IntegranteForm {

	@NotBlank
	private String nome;

	@NotNull
	private Integer idade;

	@Email
	private String email;

	@NotBlank
	private String celular;

	@NotNull
	private EnderecoForm endereco = EnderecoForm.empty();

	@NotNull
	private ComplementoForm complemento = ComplementoForm.empty();

	public static IntegranteForm empty() {
		IntegranteForm integrante = new IntegranteForm();
		integrante.nome = "";
		integrante.email = "";
		integrante.celular = "";
		integrante.idade = 0;
		integrante.endereco = EnderecoForm.empty();
		integrante.complemento = ComplementoForm.empty();
		return integrante;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public EnderecoForm getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}
	public ComplementoForm getComplemento() {
		return complemento;
	}
	public void setComplemento(ComplementoForm complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}

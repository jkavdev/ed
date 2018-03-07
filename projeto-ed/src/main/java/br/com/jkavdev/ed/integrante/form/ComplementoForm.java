package br.com.jkavdev.ed.integrante.form;

import org.hibernate.validator.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ComplementoForm {

	@NotBlank
	private String nomeMae;

	@NotBlank
	private String nomePai;

	@NotBlank
	private String celularMae;

	@NotBlank
	private String celularPai;

	@NotBlank
	private String observacao;

	@NotBlank
	private String qualMedicamento;

	@NotBlank
	private String qualAlergia;
	
	public static ComplementoForm empty() {
		ComplementoForm complemento = new ComplementoForm();
		complemento.nomeMae = "";
		complemento.nomePai = "";
		complemento.celularMae = "";
		complemento.celularPai = "";
		complemento.observacao = "";
		complemento.qualMedicamento = "";
		complemento.qualAlergia = "";
		return complemento;
	}
	
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getCelularMae() {
		return celularMae;
	}
	public void setCelularMae(String celularMae) {
		this.celularMae = celularMae;
	}
	public String getCelularPai() {
		return celularPai;
	}
	public void setCelularPai(String celularPai) {
		this.celularPai = celularPai;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getQualMedicamento() {
		return qualMedicamento;
	}
	public void setQualMedicamento(String qualMedicamento) {
		this.qualMedicamento = qualMedicamento;
	}
	public String getQualAlergia() {
		return qualAlergia;
	}
	public void setQualAlergia(String qualAlergia) {
		this.qualAlergia = qualAlergia;
	}

	@Override
	public String toString() {
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

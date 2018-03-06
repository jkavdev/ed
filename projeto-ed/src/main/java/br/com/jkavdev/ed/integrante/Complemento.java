package br.com.jkavdev.ed.integrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "complemento_integrante")
public class Complemento {

	@Id
	private Long id;

	@Column(name = "nome_mae")
	private String nomeMae;

	@Column(name = "nome_pai")
	private String nomePai;

	@Column(name = "celular_mae")
	private String celularMae;

	@Column(name = "celular_pai")
	private String celularPai;

	@Column
	private String observacao;

	@Column(name = "medicamento_utilizado")
	private String qualMedicamento;

	@Column(name = "alergia")
	private String qualAlergia;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Integrante integrante;
	
	protected Complemento() {}

	public Complemento(String nomeMae, String nomePai, String celularMae, String celularPai, String observacao, String qualMedicamento, String qualAlergia) {
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.celularMae = celularMae;
		this.celularPai = celularPai;
		this.observacao = observacao;
		this.qualMedicamento = qualMedicamento;
		this.qualAlergia = qualAlergia;
	}
	
	public static Complemento empty() {
		Complemento complemento = new Complemento();
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
	public String getNomePai() {
		return nomePai;
	}
	public String getCelularMae() {
		return celularMae;
	}
	public String getCelularPai() {
		return celularPai;
	}
	public String getObservacao() {
		return observacao;
	}
	public String getQualMedicamento() {
		return qualMedicamento;
	}
	public String getQualAlergia() {
		return qualAlergia;
	}
	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	@Override
	public String toString() {
		return  MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("nomeMae", nomeMae)
				.add("nomePai", nomePai)
				.add("celularMae", celularMae)
				.add("celularPai", celularPai)
				.add("observacao", observacao)
				.add("qualMedicamento", qualMedicamento)
				.add("qualAlergia", qualAlergia).toString();
	}

}

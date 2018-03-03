package br.com.jkavdev.ed.integrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complemento_integrante")
public class Complemento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}

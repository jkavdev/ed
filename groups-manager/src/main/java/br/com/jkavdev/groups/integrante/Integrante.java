package br.com.jkavdev.groups.integrante;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Integrante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String celular;
	
	private String email;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	private String cpf;
	
	@Column(name = "membro_da_igreja")
	private boolean membroDaIgreja;
	
	@Column(name = "membro_de_outra_igreja")
	private boolean membroDeOutraIgreja;
	
	@Column(name = "nome_da_outra_igreja")
	private String outraIgreja;
	
	@Column(name = "cadastro_efetivado")
	private boolean cadastroEfetivado;
	
	private Integrante() {}

	public Integrante(String nome, String celular, String email, Sexo sexo, LocalDate dataNascimento, String cpf) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}
	
	public static Integrante empty() {
		Integrante empty = new Integrante();
		empty.nome = "";
		empty.celular = "";
		empty.email = "";
		empty.senha = "";
		empty.celular = "";
		empty.sexo = Sexo.MASCULINO;
		empty.cpf = "";
		empty.dataNascimento = LocalDate.now();
		empty.membroDaIgreja = false;
		empty.membroDeOutraIgreja = false;
		empty.outraIgreja = "";
		empty.cadastroEfetivado = false;
		return empty;
	}
	

}

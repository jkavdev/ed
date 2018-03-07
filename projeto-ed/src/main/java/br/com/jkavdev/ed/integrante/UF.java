package br.com.jkavdev.ed.integrante;

public enum UF {
	AC("AC"),
	AL("AL"),
	AM("AM"),
	AP("AP"),
	BA("BA"),
	CE("CE"),
	DF("DF"),
	ES("ES"),
	GO("GO"),
	MA("MA"),
	MG("MG"),
	MS("MS"),
	MT("MT"),
	PA("PA"),
	PB("PB"),
	PE("PE"),
	PI("PI"),
	PR("PR"),
	RJ("RJ"),
	RN("RN"),
	RS("RS"),
	RO("RO"),
	RR("RR"),
	SC("SC"),
	SE("SE"),
	SP("SP"),
	TO("TO");
	
	private final String descricao;
	
	UF(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}

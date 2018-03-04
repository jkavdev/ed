package br.com.jkavdev.ed.test.entities.integrante;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.ed.grupo.Grupo;
import br.com.jkavdev.ed.integrante.Complemento;
import br.com.jkavdev.ed.integrante.Endereco;
import br.com.jkavdev.ed.integrante.Integrante;
import br.com.jkavdev.ed.statusgrupo.StatusGrupo;
import br.com.jkavdev.ed.test.entities.BaseTest;

public class IntegranteTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(IntegranteTest.class); 

	@Test
	public void shouldCreateAIntegrante() {
		StatusGrupo statusGrupo = new StatusGrupo("Novo Status Grupo");
		Grupo grupo = new Grupo("Novo Grupo", statusGrupo);
		
		Integrante integrante = new Integrante("Jhonatan", 21, "jhonatan@gmail.com", "12345678", criaEndereco(), criaComplemento());

		beginTransaction();
		getManager().persist(statusGrupo);
		getManager().persist(grupo);
		getManager().persist(integrante);
		commitTransaction();
		
		Integrante integranteSalvo = getSession().bySimpleNaturalId(Integrante.class).load("jhonatan@gmail.com");
		LOGGER.debug(integranteSalvo);
		
		assertNotNull(integranteSalvo);
		assertTrue(integrante.getEmail().equals(integranteSalvo.getEmail()));

	}

	public static Endereco criaEndereco() {
		return new Endereco("Qr12 Casa 15", "15", "Planaltina", "GO", "73754012", "Perto do bar do RAEL");
	}
	public static Complemento criaComplemento() {
		return new Complemento("Maria", "Marcos", "12345678", "12345678", "Novo complemento", "Nenhum", "Nenhum");
	}

}

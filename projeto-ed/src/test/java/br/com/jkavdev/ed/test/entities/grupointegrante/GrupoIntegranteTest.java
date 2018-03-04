package br.com.jkavdev.ed.test.entities.grupointegrante;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import br.com.jkavdev.ed.grupo.Grupo;
import br.com.jkavdev.ed.integrante.Complemento;
import br.com.jkavdev.ed.integrante.Endereco;
import br.com.jkavdev.ed.integrante.Integrante;
import br.com.jkavdev.ed.statusgrupo.StatusGrupo;
import br.com.jkavdev.ed.test.entities.BaseTest;

public class GrupoIntegranteTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(GrupoIntegranteTest.class); 

	@Test
	public void shouldAddAIntegranteToAGrupo() {
		beginTransaction();
		StatusGrupo statusGrupo = new StatusGrupo("Novo Status Grupo");
		Grupo grupo = new Grupo("Novo Grupo", statusGrupo);
		
		Integrante integrante = new Integrante("Jhonatan", 21, "jhonatan@gmail.com", "12345678", criaEndereco(), criaComplemento());
		Integrante integrante1 = new Integrante("Lucas", 15, "lucas@gmail.com", "12345678", criaEndereco(), criaComplemento());
		
		getManager().persist(statusGrupo);
		getManager().persist(integrante);
		getManager().persist(integrante1);
		
		getManager().persist(grupo);
		
		grupo.adicionar(integrante);
		grupo.adicionar(integrante1);
		
		commitTransaction();
		
		Grupo grupoSalvo = getManager().createQuery("SELECT g "
				+ "FROM Grupo g "
				+ "JOIN FETCH g.integrantes "
				+ "WHERE g.id = :id", Grupo.class)
			.setParameter("id", grupo.getId())
			.getSingleResult();
		LOGGER.debug(grupoSalvo);
		LOGGER.debug(integrante);
		LOGGER.debug(integrante1);
		
		assertNotNull(grupoSalvo);
		assertTrue(grupoSalvo.contemPessoa(integrante));
		assertTrue(grupoSalvo.contemPessoa(integrante1));
	}
	
	@Test
	public void shouldRemoveAIntegranteFromAGrupo() {
		beginTransaction();
		StatusGrupo statusGrupo = new StatusGrupo("Novo Status Grupo 2");
		Grupo grupo = new Grupo("Novo Grupo", statusGrupo);
		
		Integrante integrante = new Integrante("Jhonatan", 21, "jhonatan1@gmail.com", "12345678", criaEndereco(), criaComplemento());
		Integrante integrante1 = new Integrante("Lucas", 15, "lucas1@gmail.com", "12345678", criaEndereco(), criaComplemento());
		
		getManager().persist(statusGrupo);
		getManager().persist(integrante);
		getManager().persist(integrante1);
		
		getManager().persist(grupo);
		
		grupo.adicionar(integrante);
		grupo.adicionar(integrante1);
		
		Grupo grupoSalvo = getManager().createQuery("SELECT g "
				+ "FROM Grupo g "
				+ "JOIN FETCH g.integrantes "
				+ "WHERE g.id = :id", Grupo.class)
				.setParameter("id", grupo.getId())
				.getSingleResult();
		LOGGER.debug(grupoSalvo);
		LOGGER.debug(integrante);
		LOGGER.debug(integrante1);
		
		grupo.remover(integrante);
		grupo.remover(integrante1);
		commitTransaction();
		
		@SuppressWarnings("deprecation")
		Long integrates = (Long) getSession().createCriteria(Grupo.class, "g")
			.createAlias("g.integrantes", "integ")
			.createAlias("integ.grupo", "gr")
			.add(Restrictions.idEq(grupoSalvo.getId()))
			.setProjection(Projections.rowCount())
			.uniqueResult();
		
		assertNotNull(grupoSalvo);
		assertTrue(integrates.intValue() == 0);
		assertTrue(grupoSalvo.naoContemPessoa(integrante));
		assertTrue(grupoSalvo.naoContemPessoa(integrante1));
	}
	
	public static Endereco criaEndereco() {
		return new Endereco("Qr12 Casa 15", "15", "Planaltina", "GO", "73754012", "Perto do bar do RAEL");
	}
	public static Complemento criaComplemento() {
		return new Complemento("Maria", "Marcos", "12345678", "12345678", "Novo complemento", "Nenhum", "Nenhum");
	}

}

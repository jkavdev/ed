package br.com.jkavdev.ed.test.entities.grupo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.ed.grupo.Grupo;
import br.com.jkavdev.ed.statusgrupo.StatusGrupo;
import br.com.jkavdev.ed.test.entities.BaseTest;

public class GrupoTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(GrupoTest.class);
	
	@Test
	public void shouldCreateAGrupo() {
		StatusGrupo statusGrupo = new StatusGrupo("Novo Status Grupo");
		beginTransaction();
		getManager().persist(statusGrupo);

		Grupo grupo = new Grupo("Novo Grupo", statusGrupo);
		getManager().persist(grupo);
		commitTransaction();
		
		List<Grupo> grupos = getManager().createQuery("from Grupo", Grupo.class).getResultList();
		LOGGER.debug(grupo);
		LOGGER.debug(grupos);

		assertNotNull(grupos);
		assertTrue(grupos.contains(grupo));
	}


}

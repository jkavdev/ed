package br.com.jkavdev.ed.test.entities.statusgrupo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.ed.statusgrupo.StatusGrupo;
import br.com.jkavdev.ed.test.entities.BaseTest;

public class StatusGrupoTest extends BaseTest {
	
	private static final Logger LOGGER = Logger.getLogger(StatusGrupoTest.class);

	@Test
	public void shouldCreateAStatusGrupo() {
		StatusGrupo statusGrupo = new StatusGrupo("Novo Status Grupo");
		beginTransaction();
		getManager().persist(statusGrupo);
		commitTransaction();

		StatusGrupo statusGrupoSalvo = getSession().bySimpleNaturalId(StatusGrupo.class).load("Novo Status Grupo");
		LOGGER.debug(statusGrupoSalvo);

		assertNotNull(statusGrupoSalvo);
		assertEquals(statusGrupo.getNome(), statusGrupo.getNome());
	}

}

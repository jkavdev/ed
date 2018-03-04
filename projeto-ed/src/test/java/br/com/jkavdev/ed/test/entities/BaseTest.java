package br.com.jkavdev.ed.test.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void setUpBeforeTestClass() {
		factory = Persistence.createEntityManagerFactory("edTestPU");
	}

	@Before
	public void setUpBeforeTestMethod() {
		manager = factory.createEntityManager();
	}

	@After
	public void tearDownAfterTestMethod() {
		manager.close();
	}

	@AfterClass
	public static void tearDownAfterTestClass() {
		// close connections, close browser as needed
		factory.close();
	}

	public EntityManager getManager() {
		return manager;
	}
	
	public Session getSession() {
		return manager.unwrap(Session.class);
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	public void commitTransaction() {
		manager.getTransaction().commit();
	}

}

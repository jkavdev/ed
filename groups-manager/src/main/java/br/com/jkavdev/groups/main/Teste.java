package br.com.jkavdev.groups.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class Teste {

	@Test
	public void teste() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("groupsPU");
		EntityManager manager = factory.createEntityManager();

		manager.close();
		factory.close();
	}
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("groupsPU");
		EntityManager manager = factory.createEntityManager();
		
		manager.close();
		factory.close();
	}

}

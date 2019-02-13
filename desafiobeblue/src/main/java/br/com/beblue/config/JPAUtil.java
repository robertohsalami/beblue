package br.com.beblue.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("beblue");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}

package com.netbuilder.persistence_manager;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Singleton
public class PersistenceManager {
	private static final Logger logger = LogManager.getLogger();
	private EntityManagerFactory emf;

	public EntityManager createEntityManager() {
		try {
			System.out.println("EM");
			emf = Persistence.createEntityManagerFactory("orange-backend");
			EntityManager em = emf.createEntityManager();
			return em;
		} catch (PersistenceException pe) {
			logger.error("Persistence error", emf);
			pe.printStackTrace();
			return null;
		}
	}

	public void closeEntityManager(EntityManager em) {
		em.close();
		emf.close();
	}
}
package com.netbuilder.persistence_manager;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Singleton
public class PersistenceManager
{
	private EntityManagerFactory emf;
	
	public EntityManager createEntityManager()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("OrangeGardensPU");
			EntityManager em = emf.createEntityManager();
			return em;
		}
		catch(PersistenceException pe)
		{
			pe.printStackTrace();
			return null;
		}
	}
	
	public void closeEntityManager(EntityManager em)
	{
		em.close();
		emf.close();
	}
}
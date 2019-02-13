package br.com.beblue.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.beblue.config.JPAUtil;
import br.com.beblue.entidade.CashBack;

public class CashBackDao {

	public void inserirCashback(CashBack cashBack) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(cashBack);
		em.getTransaction().commit();
		em.close();				
	}

	public BigDecimal buscarValorCashBack(String genero, int dayOfWeek) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select c.porcentagem from CashBack c where c.genero =:pGenero and c.diaDaSemana =:pDiaDaSemana";
		Query query = em.createQuery(jpql);
		query.setParameter("pGenero", genero);
		query.setParameter("pDiaDaSemana", dayOfWeek);
		Integer singleResult = (Integer) query.getSingleResult();
		
		BigDecimal cashBack = new BigDecimal(singleResult);
		
		em.close();			
		
		return cashBack;
	}	

}

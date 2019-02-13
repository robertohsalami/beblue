package br.com.beblue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.beblue.config.JPAUtil;
import br.com.beblue.entidade.Discos;

public class DiscosDao {
	
	public void inserirDisco(Discos disco) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(disco);
		em.getTransaction().commit();
		em.close();
	}

	public Discos consultarDisco(int id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Discos disco = em.find(Discos.class, id);
		em.close();
		return disco;
	}

	public List<Discos> consultarCatalogoPorGenero(String genero, int pageNumber, int pageSize) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select d from Discos d where d.genero =:pGenero order by d.nome asc";		
		Query query = em.createQuery(jpql);
		query.setParameter("pGenero", genero);
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List<Discos> discos = query.getResultList();
		return discos;
	}

}

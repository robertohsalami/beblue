package br.com.beblue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.beblue.config.JPAUtil;
import br.com.beblue.entidade.Vendas;

public class VendasDao {

	public void registrarVenda(Vendas venda) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(venda);
		em.getTransaction().commit();
		em.close();		
	}

	public Vendas consultarVenda(int id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();		
		Vendas venda = em.find(Vendas.class, id);
		return venda;
	}

	public List<Vendas> consultarVendas(String dataInicial, String dataFinal, int pageNumber, int pageSize) {		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select v from Vendas v where v.dataVenda between " + "'" +dataInicial+ "'" + " and " + "'" +dataFinal+ "'" + " order by  v.dataVenda desc";
		Query query = em.createQuery(jpql);
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		List<Vendas> vendas = query.getResultList();
		
		return vendas;
	}

}

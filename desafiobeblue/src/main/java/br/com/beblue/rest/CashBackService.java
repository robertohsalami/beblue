package br.com.beblue.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.beblue.dao.CashBackDao;
import br.com.beblue.entidade.CashBack;

@Path("/cashback")
public class CashBackService {
	
	private CashBackDao cashBackDao;
	
	@PostConstruct
	private void init() {
		this.cashBackDao = new CashBackDao();
	}
	
	@POST
	@Path("/inserirCashback")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserirCashback(List<CashBack> cashBack) {
		for (CashBack cash : cashBack) {
			cashBackDao.inserirCashback(cash);			
		}		
		return "Cashback inserido com sucesso";
	}

}

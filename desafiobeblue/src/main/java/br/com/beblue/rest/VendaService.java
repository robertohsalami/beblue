package br.com.beblue.rest;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.beblue.dao.CashBackDao;
import br.com.beblue.dao.VendasDao;
import br.com.beblue.entidade.Discos;
import br.com.beblue.entidade.Vendas;

@Path("/venda")
public class VendaService {

	private VendasDao vendaDao;

	private CashBackDao cashBackDao;

	@PostConstruct
	private void init() {
		this.vendaDao = new VendasDao();
		this.cashBackDao = new CashBackDao();
	}

	@GET
	@Path("/{dataInicial}/{dataFinal}/{pageNumber}/{pageSize}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vendas> consultarVendas(@PathParam("dataInicial") String dataInicial,
			@PathParam("dataFinal") String dataFinal, @PathParam("pageNumber") int pageNumber,
			@PathParam("pageSize") int pageSize) {
		return vendaDao.consultarVendas(dataInicial, dataFinal, pageNumber, pageSize);
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vendas consultarVenda(@PathParam("id") int id) {
		return vendaDao.consultarVenda(id);
	}

	@POST
	@Path("/registrarVenda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vendas registrarVenda(List<Discos> discos) {
		Calendar dataVenda = Calendar.getInstance();
		int dayOfWeek = dataVenda.get(Calendar.DAY_OF_WEEK);
		BigDecimal totalCashBack = new BigDecimal(0);
		BigDecimal valorTotal = new BigDecimal(0);

		for (Discos disco : discos) {
			BigDecimal porcentagemCashBack = cashBackDao.buscarValorCashBack(disco.getGenero(), dayOfWeek);
			BigDecimal cashBack = disco.getPreco().multiply(porcentagemCashBack).divide(new BigDecimal(100));

			BigDecimal totalCash = totalCashBack.add(cashBack);
			totalCashBack = totalCash;
			BigDecimal total = valorTotal.add(disco.getPreco());
			valorTotal = total;
		}

		Vendas venda = new Vendas();
		venda.setDataVenda(dataVenda);
		venda.setDiscos(discos);
		venda.setTotalCashBack(totalCashBack);
		venda.setValorTotal(valorTotal);

		vendaDao.registrarVenda(venda);

		return venda;

	}

}

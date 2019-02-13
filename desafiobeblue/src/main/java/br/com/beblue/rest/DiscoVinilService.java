package br.com.beblue.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.beblue.dao.DiscosDao;
import br.com.beblue.entidade.Discos;

@Path("/disco")
public class DiscoVinilService {
	
	private DiscosDao discoDao;
	
	@PostConstruct
	private void init() {
		discoDao = new DiscosDao();
	}

	@GET
	@Path("/catalogo/{genero}/{pageNumber}/{pageSize}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Discos> consultarCatalogoPorGenero(@PathParam("genero") String genero, @PathParam("pageNumber") int pageNumber, 
			@PathParam("pageSize") int pageSize) {
		List<Discos> discos = discoDao.consultarCatalogoPorGenero(genero, pageNumber, pageSize);
		return discos;
	}

	@GET
	@Path("/consultarDisco/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Discos consultarDisco(@PathParam("id") int id) {
		return discoDao.consultarDisco(id);
	}
	
	@POST
	@Path("/inserirDisco")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String inserirDisco(List<Discos> discos) {
		for (Discos disco : discos) {
			discoDao.inserirDisco(disco);			
		}		
		return "Disco(s) inserido(s) com sucesso!";
	}

}

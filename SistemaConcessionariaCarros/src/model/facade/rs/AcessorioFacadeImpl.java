package model.facade.rs;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AcessorioDao;
import model.domain.Acessorio;

@Path("/Acessorio")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class AcessorioFacadeImpl implements AcessorioFacade {
	
//	private static List<Acessorio> Acessorios = new ArrayList<Acessorio>();
	
	@Inject
	private AcessorioDao acessorioDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AcessorioFacade#salvar(model.domain.Acessorio)
	 */
	@Override
	@POST
	public Acessorio salvar(Acessorio Acessorio) {
		Acessorio = acessorioDao.salvar(Acessorio);
		return Acessorio;
	}
	
	@Override
	@GET
	public List<Acessorio> getAcessorios() {
		return acessorioDao.getAcessorios(new Acessorio());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Acessorio> getAcessorios(@PathParam("codigo") Integer codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodAcessorio(codigo);
		return acessorioDao.getAcessorios(acessorio);
	}
	
	
	@Override
	@PUT
	public void atualizar(Acessorio acessorio) {
		acessorioDao.atualizar(acessorio);
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAcessorio(@PathParam("codigo") Integer codigo) {
		
			Acessorio acessorio =  new Acessorio();
			acessorio.setCodAcessorio(codigo);
			acessorioDao.excluir(acessorio);
		
	}


}

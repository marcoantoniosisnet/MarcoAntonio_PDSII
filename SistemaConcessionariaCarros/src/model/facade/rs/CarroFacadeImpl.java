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

import model.dao.CarroDao;
import model.domain.Carro;

@Path("/Carro")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class CarroFacadeImpl implements CarroFacade {
	
//	private static List<Carro> Carros = new ArrayList<Carro>();
	
	@Inject
	private CarroDao carroDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.CarroFacade#salvar(model.domain.Carro)
	 */
	@Override
	@POST
	public Carro salvar(Carro carro) {
		carro = carroDao.salvar(carro);
		return carro;
	}
	
	@Override
	@GET
	public List<Carro> getCarros() {
		return carroDao.getCarros(new Carro());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Carro> getCarros(@PathParam("codigo") Integer codigo) {
		Carro carro = new Carro();
		carro.setCodCarro(codigo);
		return carroDao.getCarros(carro);
	}
	
	
	@Override
	@PUT
	public void atualizar(Carro carro) {
		carroDao.atualizar(carro);
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarCarro(@PathParam("codigo") Integer codigo) {
		
			Carro carro =  new Carro();
			carro.setCodCarro(codigo);
			carroDao.excluir(carro);
		
	}



}

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

import model.dao.ArtistaDao;
import model.domain.Artista;

@Path("/Artista")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class ArtistaFacadeImpl implements ArtistaFacade {
	
//	private static List<Artista> Artistas = new ArrayList<Artista>();
	
	@Inject
	private ArtistaDao artistaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ArtistaFacade#salvar(model.domain.Artista)
	 */
	@Override
	@POST
	public Artista salvar(Artista Artista) {
		Artista = artistaDao.salvar(Artista);
		return Artista;
	}
	
	@Override
	@GET
	public List<Artista> getArtistas() {
		return artistaDao.getArtistas(new Artista());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Artista> getArtistas(@PathParam("codigo") Integer codigo) {
		Artista Artista = new Artista();
		Artista.setCodArtista(codigo);
		return artistaDao.getArtistas(Artista);
	}
	
	
	@Override
	@PUT
	public void atualizar(Artista Artista) {
		artistaDao.atualizar(Artista);
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarArtista(@PathParam("codigo") Integer codigo) {
		
			Artista Artista =  new Artista();
			Artista.setCodArtista(codigo);
			artistaDao.excluir(Artista);
		
	}



}

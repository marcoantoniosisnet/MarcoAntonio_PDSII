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

import model.dao.MusicaDao;
import model.domain.Musica;

@Path("/Musica")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class MusicaFacadeImpl implements MusicaFacade {
	
//	private static List<Musica> Musicas = new ArrayList<Musica>();
	
	@Inject
	private MusicaDao musicaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.MusicaFacade#salvar(model.domain.Musica)
	 */
	@Override
	@POST
	public Musica salvar(Musica Musica) {
		Musica = musicaDao.salvar(Musica);
		return Musica;
	}
	
	@Override
	@GET
	public List<Musica> getMusicas() {
		return musicaDao.getMusicas(new Musica());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Musica> getMusicas(@PathParam("codigo") Integer codigo) {
		Musica Musica = new Musica();
		Musica.setCodMusica(codigo);
		return musicaDao.getMusicas(Musica);
	}
	
	
	@Override
	@PUT
	public void atualizar(Musica Musica) {
		musicaDao.atualizar(Musica);
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMusica(@PathParam("codigo") Integer codigo) {
		
			Musica Musica =  new Musica();
			Musica.setCodMusica(codigo);
			musicaDao.excluir(Musica);
		
	}



}

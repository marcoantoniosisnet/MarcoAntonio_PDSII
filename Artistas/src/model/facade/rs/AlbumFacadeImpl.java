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

import model.dao.AlbumDao;
import model.domain.Album;

@Path("/Album")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class AlbumFacadeImpl implements AlbumFacade {
	
//	private static List<Album> Albums = new ArrayList<Album>();
	
	@Inject
	private AlbumDao albumDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.AlbumFacade#salvar(model.domain.Album)
	 */
	@Override
	@POST
	public Album salvar(Album Album) {
		Album = albumDao.salvar(Album);
		return Album;
	}
	
	@Override
	@GET
	public List<Album> getAlbums() {
		return albumDao.getAlbums(new Album());
	}
	
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Album> getAlbums(@PathParam("codigo") Integer codigo) {
		Album Album = new Album();
		Album.setCodAlbum(codigo);
		return albumDao.getAlbums(Album);
	}
	
	
	@Override
	@PUT
	public void atualizar(Album Album) {
		albumDao.atualizar(Album);
	}
	
	
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAlbum(@PathParam("codigo") Integer codigo) {
		
			Album Album =  new Album();
			Album.setCodAlbum(codigo);
			albumDao.excluir(Album);
		
	}


}

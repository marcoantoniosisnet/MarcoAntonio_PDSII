package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.AlbumDao;
import model.domain.Album;

@WebService(serviceName="ws/album")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class AlbumFacadeImpl implements AlbumFacade {
	
	@Inject
	private AlbumDao AlbumDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.AlbumFacade#getAlbums()
	 */
	
	@WebMethod
	public List<Album> getAlbums() {
		return AlbumDao.getAlbums(new Album());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.AlbumFacade#getAlbums(model.domain.Album)
	 */
	
	@WebMethod(operationName="getAlbumCodigo")
	public List<Album> getAlbums(@WebParam(name="codigoAlbum")Integer codigo) {
		Album Album =  new Album();
		Album.setCodAlbum(codigo);
		return AlbumDao.getAlbums(Album);
	}
	
	
	@WebMethod
	public Album salvar(@WebParam(name="Album")Album Album) {
		Album = AlbumDao.salvar(Album);
		return Album;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="Album")Album Album) {
		AlbumDao.atualizar(Album);
	}
	
	
	
	@WebMethod
	public void deletarAlbum(@WebParam(name="codigoAlbum")Integer codigo) {
		
		Album Album =  new Album();
		Album.setCodAlbum(codigo);
	    AlbumDao.excluir(Album);
	
}

	
}

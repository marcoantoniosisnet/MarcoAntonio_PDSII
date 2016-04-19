package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.ArtistaDao;
import model.domain.Artista;

@WebService(serviceName="ws/artista")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class ArtistaFacadeImpl implements ArtistaFacade {
	
	@Inject
	private ArtistaDao ArtistaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.ArtistaFacade#getArtistas()
	 */
	
	@WebMethod
	public List<Artista> getArtistas() {
		return ArtistaDao.getArtistas(new Artista());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.ArtistaFacade#getArtistas(model.domain.Artista)
	 */
	
	@WebMethod(operationName="getArtistaCodigo")
	public List<Artista> getArtistas(@WebParam(name="codigoArtista")Integer codigo) {
		Artista Artista =  new Artista();
		Artista.setCodArtista(codigo);
		return ArtistaDao.getArtistas(Artista);
	}
	
	
	@WebMethod
	public Artista salvar(@WebParam(name="Artista")Artista Artista) {
		Artista = ArtistaDao.salvar(Artista);
		return Artista;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="Artista")Artista Artista) {
		ArtistaDao.atualizar(Artista);
	}
	
	
	
	@WebMethod
	public void deletarArtista(@WebParam(name="codigoArtista")Integer codigo) {
		
		Artista Artista =  new Artista();
		Artista.setCodArtista(codigo);
	    ArtistaDao.excluir(Artista);
	
}

	
}

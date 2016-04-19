package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.MusicaDao;
import model.domain.Musica;

@WebService(serviceName="ws/musica")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class MusicaFacadeImpl implements MusicaFacade {
	
	@Inject
	private MusicaDao MusicaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.MusicaFacade#getMusicas()
	 */
	
	@WebMethod
	public List<Musica> getMusicas() {
		return MusicaDao.getMusicas(new Musica());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.MusicaFacade#getMusicas(model.domain.Musica)
	 */
	
	@WebMethod(operationName="getMusicaCodigo")
	public List<Musica> getMusicas(@WebParam(name="codigoMusica")Integer codigo) {
		Musica Musica =  new Musica();
		Musica.setCodMusica(codigo);
		return MusicaDao.getMusicas(Musica);
	}
	
	
	@WebMethod
	public Musica salvar(@WebParam(name="Musica")Musica Musica) {
		Musica = MusicaDao.salvar(Musica);
		return Musica;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="Musica")Musica Musica) {
		MusicaDao.atualizar(Musica);
	}
	
	
	
	@WebMethod
	public void deletarMusica(@WebParam(name="codigoMusica")Integer codigo) {
		
		Musica Musica =  new Musica();
		Musica.setCodMusica(codigo);
	    MusicaDao.excluir(Musica);
	
}

	
}

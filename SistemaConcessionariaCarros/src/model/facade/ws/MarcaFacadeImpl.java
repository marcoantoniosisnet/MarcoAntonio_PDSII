package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.MarcaDao;
import model.domain.Marca;

@WebService(serviceName="ws/Marca")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class MarcaFacadeImpl implements MarcaFacade {
	
	@Inject
	private MarcaDao marcaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.MarcaFacade#getMarcas()
	 */
	
	@WebMethod
	public List<Marca> getMarcas() {
		return marcaDao.getMarcas(new Marca());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.MarcaFacade#getMarcas(model.domain.Marca)
	 */
	
	@WebMethod(operationName="getMarcaCodigo")
	public List<Marca> getMarcas(@WebParam(name="codigoMarca")Integer codigo) {
		Marca marca =  new Marca();
		marca.setCodMarca(codigo);
		return marcaDao.getMarcas(marca);
	}
	
	
	@WebMethod
	public Marca salvar(@WebParam(name="marca")Marca marca) {
		marca = marcaDao.salvar(marca);
		return marca;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="marca")Marca marca) {
		marcaDao.atualizar(marca);
	}
	
	
	
	@WebMethod
	public void deletarMarca(@WebParam(name="codigoMarca")Integer codigo) {
		
		Marca marca =  new Marca();
		marca.setCodMarca(codigo);
	    marcaDao.excluir(marca);
	
}

	
}

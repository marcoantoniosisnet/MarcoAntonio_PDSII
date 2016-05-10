package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.CarroDao;
import model.domain.Carro;

@WebService(serviceName="ws/Carro")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class CarroFacadeImpl implements CarroFacade {
	
	@Inject
	private CarroDao carroDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.CarroFacade#getCarros()
	 */
	
	@WebMethod
	public List<Carro> getCarros() {
		return carroDao.getCarros(new Carro());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.CarroFacade#getCarros(model.domain.Carro)
	 */
	
	@WebMethod(operationName="getCarroCodigo")
	public List<Carro> getCarros(@WebParam(name="codigoCarro")Integer codigo) {
		Carro carro =  new Carro();
		carro.setCodCarro(codigo);
		return carroDao.getCarros(carro);
	}
	
	
	@WebMethod
	public Carro salvar(@WebParam(name="carro")Carro carro) {
		carro = carroDao.salvar(carro);
		return carro;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="carro")Carro carro) {
		carroDao.atualizar(carro);
	}
	
	
	
	@WebMethod
	public void deletarCarro(@WebParam(name="codigoCarro")Integer codigo) {
		
		Carro carro =  new Carro();
		carro.setCodCarro(codigo);
	    carroDao.excluir(carro);
	
}

	
}

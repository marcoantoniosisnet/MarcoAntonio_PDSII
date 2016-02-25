package model.faced.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Arrays;
import java.util.List;

import model.domain.Cliente;


@WebService(serviceName="ws/cliente")
public class ClienteFacade {
	
	@WebMethod
public List<Cliente> getCliente(){
		
	
	return Arrays.asList(new Cliente(1, "Marco Antonio","marcoantoniosisnet@hotmail.com"),
			new Cliente (2, "Eliseu ","eliseumcd@gmail.com"));
	}
}

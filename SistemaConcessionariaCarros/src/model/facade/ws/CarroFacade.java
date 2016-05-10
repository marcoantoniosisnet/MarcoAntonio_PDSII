package model.facade.ws;

import java.util.List;

import model.domain.Carro;

public interface CarroFacade {

	List<Carro> getCarros();

	Carro salvar(Carro carro);

	List<Carro> getCarros(Integer codigo);

	public void atualizar(Carro carro);

	public void deletarCarro(Integer codigo);

}
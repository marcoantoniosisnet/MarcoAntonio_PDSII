package model.facade.rs;

import java.util.List;

import model.domain.Carro;

public interface CarroFacade {

	Carro salvar(Carro carro);

	List<Carro> getCarros();

	List<Carro> getCarros(Integer codigo);

	public void atualizar(Carro carro);

	public void deletarCarro(Integer codigo);

}
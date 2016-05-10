package model.dao;

import java.util.List;

import model.domain.Carro;

public interface CarroDao {

	List<Carro> getCarros(Carro carro);

	public void excluir(Carro carro);

	 Carro salvar(Carro carro);

	public void atualizar(Carro carro);

}
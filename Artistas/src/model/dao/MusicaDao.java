package model.dao;

import java.util.List;

import model.domain.Musica;

public interface MusicaDao {

	List<Musica> getMusicas(Musica Musica);

	public void excluir(Musica Musica);

	 Musica salvar(Musica Musica);

	public void atualizar(Musica Musica);

}
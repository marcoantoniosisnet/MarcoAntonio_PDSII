package model.facade.ws;

import java.util.List;

import model.domain.Musica;

public interface MusicaFacade {

	List<Musica> getMusicas();

	Musica salvar(Musica Musica);

	List<Musica> getMusicas(Integer codigo);

	public void atualizar(Musica Musica);

	public void deletarMusica(Integer codigo);

}
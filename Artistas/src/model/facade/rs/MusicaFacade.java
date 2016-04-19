package model.facade.rs;

import java.util.List;

import model.domain.Musica;

public interface MusicaFacade {

	Musica salvar(Musica Musica);

	List<Musica> getMusicas();

	List<Musica> getMusicas(Integer codigo);

	public void atualizar(Musica Musica);

	public void deletarMusica(Integer codigo);

}
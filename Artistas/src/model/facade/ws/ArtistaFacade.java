package model.facade.ws;

import java.util.List;

import model.domain.Artista;

public interface ArtistaFacade {

	List<Artista> getArtistas();

	Artista salvar(Artista Artista);

	List<Artista> getArtistas(Integer codigo);

	public void atualizar(Artista Artista);

	public void deletarArtista(Integer codigo);

}
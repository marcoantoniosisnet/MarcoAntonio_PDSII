package model.facade.rs;

import java.util.List;

import model.domain.Artista;

public interface ArtistaFacade {

	Artista salvar(Artista Artista);

	List<Artista> getArtistas();

	List<Artista> getArtistas(Integer codigo);

	public void atualizar(Artista Artista);

	public void deletarArtista(Integer codigo);

}
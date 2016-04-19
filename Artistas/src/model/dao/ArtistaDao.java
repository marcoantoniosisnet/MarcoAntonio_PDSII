package model.dao;

import java.util.List;

import model.domain.Artista;

public interface ArtistaDao {

	List<Artista> getArtistas(Artista Artista);

	public void excluir(Artista Artista);

	 Artista salvar(Artista Artista);

	public void atualizar(Artista Artista);

}
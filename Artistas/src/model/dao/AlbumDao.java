package model.dao;

import java.util.List;

import model.domain.Album;

public interface AlbumDao {

	List<Album> getAlbums(Album Album);

	public void excluir(Album Album);

	 Album salvar(Album Album);

	public void atualizar(Album Album);

}
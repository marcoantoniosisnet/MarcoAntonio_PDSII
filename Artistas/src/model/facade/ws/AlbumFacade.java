package model.facade.ws;

import java.util.List;

import model.domain.Album;

public interface AlbumFacade {

	List<Album> getAlbums();

	Album salvar(Album Album);

	List<Album> getAlbums(Integer codigo);

	public void atualizar(Album Album);

	public void deletarAlbum(Integer codigo);

}
package model.facade.rs;

import java.util.List;

import model.domain.Album;

public interface AlbumFacade {

	Album salvar(Album Album);

	List<Album> getAlbums();

	List<Album> getAlbums(Integer codigo);

	public void atualizar(Album Album);

	public void deletarAlbum(Integer codigo);

}
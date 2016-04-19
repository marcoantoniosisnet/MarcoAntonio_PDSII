package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Album;

public class AlbumDaoImpl implements AlbumDao {

	@PersistenceContext(unitName = "SistemaArtistasPU")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.AlbumDao#getAlbums(model.domain.Album)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> getAlbums(Album Album) {
		StringBuffer hql = new StringBuffer("from Album c " + "where 1 = 1 ");
		if (Album.getCodAlbum() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (Album.getCodAlbum() != null) {
			query.setParameter("codigo", Album.getCodAlbum());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Album Album){
		Album= entityManager.merge(Album);
		Album guilherme = entityManager.find(Album.class, 1);
		entityManager.remove(guilherme);
	}
	@Override
	@Transactional
	public Album salvar(Album Album){
		 entityManager.persist(Album);
		return Album;
	}
	@Override
	@Transactional
	public void atualizar(Album Album){
		Album= entityManager.merge(Album);
		 entityManager.persist(Album);
	}
}

package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	@PersistenceContext(unitName = "SistemaArtistasPU")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.ArtistaDao#getArtistas(model.domain.Artista)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Artista> getArtistas(Artista Artista) {
		StringBuffer hql = new StringBuffer("from Artista c " + "where 1 = 1 ");
		if (Artista.getCodArtista() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (Artista.getCodArtista() != null) {
			query.setParameter("codigo", Artista.getCodArtista());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Artista Artista){
		Artista= entityManager.merge(Artista);
		Artista artista = entityManager.find(Artista.class, 1);
		entityManager.remove(artista);
	}
	@Override
	@Transactional
	public Artista salvar(Artista Artista){
		 entityManager.persist(Artista);
		return Artista;
	}
	@Override
	@Transactional
	public void atualizar(Artista Artista){
		Artista= entityManager.merge(Artista);
		 entityManager.persist(Artista);
	}
}

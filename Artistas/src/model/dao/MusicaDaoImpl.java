package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Musica;

public class MusicaDaoImpl implements MusicaDao {

	@PersistenceContext(unitName = "SistemaArtistasPU")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.MusicaDao#getMusicas(model.domain.Musica)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Musica> getMusicas(Musica Musica) {
		StringBuffer hql = new StringBuffer("from Musica c " + "where 1 = 1 ");
		if (Musica.getCodMusica() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (Musica.getCodMusica() != null) {
			query.setParameter("codigo", Musica.getCodMusica());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Musica Musica){
		Musica= entityManager.merge(Musica);
		Musica guilherme = entityManager.find(Musica.class, 1);
		entityManager.remove(guilherme);
	}
	@Override
	@Transactional
	public Musica salvar(Musica Musica){
		 entityManager.persist(Musica);
		return Musica;
	}
	@Override
	@Transactional
	public void atualizar(Musica Musica){
		Musica= entityManager.merge(Musica);
		 entityManager.persist(Musica);
	}
}

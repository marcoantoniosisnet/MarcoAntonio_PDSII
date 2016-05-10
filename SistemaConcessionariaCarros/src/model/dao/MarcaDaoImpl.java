package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Marca;

public class MarcaDaoImpl implements MarcaDao {

	@PersistenceContext(unitName = "SistemaConcessionariaCarrosPu")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.MarcaDao#getMarcas(model.domain.Marca)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Marca> getMarcas(Marca marca) {
		StringBuffer hql = new StringBuffer("from Marca c " + "where 1 = 1 ");
		if (marca.getCodMarca() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (marca.getCodMarca() != null) {
			query.setParameter("codigo", marca.getCodMarca());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Marca marca){
		marca= entityManager.merge(marca);
		Marca marc = entityManager.find(Marca.class, 1);
		entityManager.remove(marc);
	}
	@Override
	@Transactional
	public Marca salvar(Marca marca){
		 entityManager.persist(marca);
		return marca;
	}
	@Override
	@Transactional
	public void atualizar(Marca marca){
		marca= entityManager.merge(marca);
		 entityManager.persist(marca);
	}
}

package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Acessorio;

public class AcessorioDaoImpl implements AcessorioDao {

	@PersistenceContext(unitName = "SistemaConcessionariaCarrosPu")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.AcessorioDao#getAcessorios(model.domain.Acessorio)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Acessorio> getAcessorios(Acessorio acessorio) {
		StringBuffer hql = new StringBuffer("from Acessorio c " + "where 1 = 1 ");
		if (acessorio.getCodAcessorio() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (acessorio.getCodAcessorio() != null) {
			query.setParameter("codigo", acessorio.getCodAcessorio());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Acessorio acessorio){
		acessorio= entityManager.merge(acessorio);
		Acessorio ac = entityManager.find(Acessorio.class, 1);
		entityManager.remove(ac);
	}
	@Override
	@Transactional
	public Acessorio salvar(Acessorio acessorio){
		 entityManager.persist(acessorio);
		return acessorio;
	}
	@Override
	@Transactional
	public void atualizar(Acessorio acessorio){
		acessorio= entityManager.merge(acessorio);
		 entityManager.persist(acessorio);
	}
}

package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Carro;

public class CarroDaoImpl implements CarroDao {

	@PersistenceContext(unitName = "SistemaConcessionariaCarrosPu")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see model.dao.CarroDao#getCarros(model.domain.Carro)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Carro> getCarros(Carro carro) {
		StringBuffer hql = new StringBuffer("from Carro c " + "where 1 = 1 ");
		if (carro.getCodCarro() != null) {
			hql.append("and c.codigo= :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (carro.getCodCarro() != null) {
			query.setParameter("codigo", carro.getCodCarro());
		}
		return query.getResultList();
	}
	@Override
	@Transactional
	public void excluir(Carro carro){
		carro= entityManager.merge(carro);
		Carro car = entityManager.find(Carro.class, 1);
		entityManager.remove(car);
	}
	@Override
	@Transactional
	public Carro salvar(Carro carro){
		 entityManager.persist(carro);
		return carro;
	}
	@Override
	@Transactional
	public void atualizar(Carro carro){
		carro= entityManager.merge(carro);
		 entityManager.persist(carro);
	}
}

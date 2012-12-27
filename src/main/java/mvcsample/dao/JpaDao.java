package mvcsample.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class JpaDao<K, E> implements BaseDao<K, E> {
	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public E update(E entity){
		return this.entityManager.merge(entity);
	}

	public E persist(E entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	public void remove(E entity) {
		this.entityManager.remove(entity);
	}

	public E findById(K id) {
		return this.entityManager.find(this.entityClass, id);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
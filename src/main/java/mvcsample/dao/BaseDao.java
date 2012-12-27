package mvcsample.dao;


public interface BaseDao<K,E> {
	E persist(E entity);
	E update(E entity);
	void remove(E entity);
	E findById(K key);
	
}

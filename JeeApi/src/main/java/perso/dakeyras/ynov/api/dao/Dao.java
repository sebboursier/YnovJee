/**
 * 
 */
package perso.dakeyras.ynov.api.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * @author sebboursier
 *
 */
public abstract class Dao {

	@Transactional
	public static <T> List<T> find(final String queryString, final Map<String, Object> params) {
		List<T> itemList = null;
		EntityManager em = null;

		try {
			em = JpaManager.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();

			Query query = em.createNamedQuery(queryString);

			if (params != null) {
				for (Entry<String, Object> param : params.entrySet()) {
					query.setParameter(param.getKey(), param.getValue());
				}
			}

			itemList = query.getResultList();

			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return itemList;
	}

	@Transactional
	public static <T> T findOne(final String queryString, final Map<String, Object> params) {
		T item = null;
		EntityManager em = null;

		try {
			em = JpaManager.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();

			Query query = em.createNamedQuery(queryString);

			if (params != null) {
				for (Entry<String, Object> param : params.entrySet()) {
					query.setParameter(param.getKey(), param.getValue());
				}
			}

			item = (T) query.getSingleResult();

			em.getTransaction().commit();
		} catch (NoResultException ex) {
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return item;
	}

	@Transactional
	public static <T> T saveOrUpdate(T item) {
		EntityManager em = null;

		try {
			em = JpaManager.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();

			item = em.merge(item);
			em.persist(item);

			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return item;
	}

	@Transactional
	public static int execute(final String queryString) {
		EntityManager em = null;
		int nb = 0;

		try {
			em = JpaManager.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();

			Query query = em.createNamedQuery(queryString);
			nb = query.executeUpdate();

			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return nb;
	}
}

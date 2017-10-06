/**
 * 
 */
package perso.dakeyras.ynov.api.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author sebboursier
 *
 */
public class JpaManager {

	private static EntityManagerFactory factory = null;

	public static PersistenceUnit unit = PersistenceUnit.RAM;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(unit.name());
		}
		return factory;
	}

	/**
	 * Clot l'EntityManagerFactory si il existe.
	 */
	public static void closeEntityManagerFactory() {
		if (factory != null) {
			factory.close();
			factory = null;
		}
	}

	/**
	 * Pour savoir si la factory est cree ou pas. Sert surtout pour les TU, peut
	 * d'utilite sinon.
	 * 
	 * @return boolean
	 */
	public static boolean isSetEntityManagerFactory() {
		return (factory != null);
	}
}
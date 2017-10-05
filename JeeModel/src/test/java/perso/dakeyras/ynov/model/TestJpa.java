/**
 * 
 */
package perso.dakeyras.ynov.model;

import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author sebboursier
 *
 */
public class TestJpa {

	@Test
	public void test() {
		Persistence.createEntityManagerFactory("TEST");
	}

}

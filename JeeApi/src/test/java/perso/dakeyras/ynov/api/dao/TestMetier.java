/**
 * 
 */
package perso.dakeyras.ynov.api.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import perso.dakeyras.ynov.model.Client;

/**
 * @author sebboursier
 *
 */
public class TestMetier {

	@BeforeClass
	public static void beforeClass() {
		JpaManager.unit = PersistenceUnit.RAM;
	}

	@After
	public void after() {
		Dao.execute("Client.removeAll");
		Dao.execute("Compte.removeAll");
		Dao.execute("Transaction.removeAll");
	}

	@Test
	public void testConnexionOk() {
		JpaManager.getEntityManagerFactory();

		final Client client = new Client();
		client.setLogin("Boby");
		client.setPassword("ybob");
		client.setNom("Bob");
		Dao.saveOrUpdate(client);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", "Boby");
		params.put("password", "ybob");
		Assert.assertNotNull(Dao.findOne("Client.findByLoginAndPassword", params));
	}

	@Test
	public void testConnexionKo() {
		JpaManager.getEntityManagerFactory();

		final Client client = new Client();
		client.setLogin("Boby");
		client.setPassword("ybob");
		client.setNom("Bob");
		Dao.saveOrUpdate(client);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", "KO");
		params.put("password", "KO");
		Assert.assertNull(Dao.findOne("Client.findByLoginAndPassword", params));
	}

}

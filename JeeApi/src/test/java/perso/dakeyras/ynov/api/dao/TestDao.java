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
import perso.dakeyras.ynov.model.Compte;
import perso.dakeyras.ynov.model.Transaction;

/**
 * @author sebboursier
 *
 */
public class TestDao {

	@BeforeClass
	public static void beforeClass() {
		JpaManager.unit = PersistenceUnit.RAM;
	}

	@After
	public void after() {
		Dao.execute("Transaction.removeAll");
		Dao.execute("Compte.removeAll");
		Dao.execute("Client.removeAll");
	}

	@Test
	public void testJpa() {
		JpaManager.getEntityManagerFactory();
		Assert.assertTrue(JpaManager.isSetEntityManagerFactory());
	}

	@Test
	public void testClient() {
		JpaManager.getEntityManagerFactory();

		Client client = new Client();
		client.setNom("Bob");
		Assert.assertNull(client.getId());

		client = Dao.saveOrUpdate(client);
		Assert.assertNotNull(client.getId());
		Assert.assertEquals("Bob", client.getNom());

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", client.getId());
		Assert.assertNotNull(Dao.findOne("Client.findById", params));
	}

	@Test
	public void testCompte() {
		JpaManager.getEntityManagerFactory();

		Compte compte = new Compte();
		compte.setLibelle("Bob");
		Assert.assertNull(compte.getId());

		compte = Dao.saveOrUpdate(compte);
		Assert.assertNotNull(compte.getId());
		Assert.assertEquals("Bob", compte.getLibelle());

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", compte.getId());
		Assert.assertNotNull(Dao.findOne("Compte.findById", params));
	}

	@Test
	public void testTransaction() {
		JpaManager.getEntityManagerFactory();

		Transaction transaction = new Transaction();
		transaction.setLibelle("Bob");
		Assert.assertNull(transaction.getId());

		transaction = Dao.saveOrUpdate(transaction);
		Assert.assertNotNull(transaction.getId());
		Assert.assertEquals("Bob", transaction.getLibelle());

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", transaction.getId());
		Assert.assertNotNull(Dao.findOne("Transaction.findById", params));
	}

	@Test
	public void testFetch() {
		JpaManager.getEntityManagerFactory();

		Client client = new Client();
		client.setNom("Bob");
		client = Dao.saveOrUpdate(client);

		Compte c1 = new Compte();
		c1.setClient(client);
		c1 = Dao.saveOrUpdate(c1);

		Compte c2 = new Compte();
		c2.setClient(client);
		c2 = Dao.saveOrUpdate(c2);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", client.getId());
		client = Dao.findOne("Client.findById", params);

		Assert.assertEquals(2, client.getComptes().size());
	}
}

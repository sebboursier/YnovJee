/**
 * 
 */
package perso.dakeyras.ynov.client.util;

import perso.dakeyras.ynov.model.Client;

/**
 * @author sebboursier
 *
 */
public abstract class BouchonUtils {

	public static Client getClient() {
		final Client client = new Client();
		client.setId(1L);
		client.setNom("Bob");
		client.setPrenom("Boby");
		client.setPrenom("Boby");
		client.setLogin("McBobFace");
		client.setPassword("iambob");
		return client;
	}

}

/**
 * 
 */
package perso.dakeyras.ynov.client.util;

import java.util.ArrayList;
import java.util.List;

import perso.dakeyras.ynov.model.Client;
import perso.dakeyras.ynov.model.Compte;

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

		final List<Compte> comptes = new ArrayList<Compte>();
		for (int i = 0; i < 5; i++) {
			final Compte compte = new Compte();
			compte.setClient(client);
			compte.setLibelle("Compte n° " + i);
			comptes.add(compte);
		}
		client.setComptes(comptes);

		return client;
	}

}

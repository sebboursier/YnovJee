/**
 * 
 */
package perso.dakeyras.ynov.client.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import perso.dakeyras.ynov.model.Client;
import perso.dakeyras.ynov.model.Compte;
import perso.dakeyras.ynov.model.Transaction;

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
			compte.setId(42L * i);
			compte.setAmount(234255D);
			compte.setClient(client);
			compte.setLibelle("Compte n° " + i);
			comptes.add(compte);
		}
		client.setComptes(comptes);

		return client;
	}

	public static Compte getCompte(Long id) {
		final Compte compte = new Compte();
		compte.setId(id);
		compte.setAmount(234255D);
		compte.setLibelle("Compte test");

		final List<Transaction> transactions = new ArrayList<Transaction>();
		for (int i = 0; i < 5; i++) {
			final Transaction transaction = new Transaction();
			transaction.setId(124976L);
			transaction.setCompte(compte);
			transaction.setDate(new Date());
			transaction.setLibelle("Transaction n°" + i);
			transaction.setMontant(i * 42.0);
			transactions.add(transaction);
		}
		compte.setTransactions(transactions);

		return compte;
	}

}

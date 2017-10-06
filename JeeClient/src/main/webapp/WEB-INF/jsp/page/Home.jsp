<main class="container">
	<section class="card-panel">
		<div class="row">
			<article class="col s6 center-align">
				Bonjour ${client.prenom} ${client.nom}
			</article>
			<article class="col s6 center-align">
				<label>
					Identifiant
				</label>
				<span>
					${client.id}
				</span>
			</article>
		</div>
	</section>
	<ul class="collection with-header">
		<li class="collection-header"><h4>Comptes disponibles</h4></li>
		<li class="collection-item">Compte 1</li>
        <li class="collection-item">Compte 2</li>
	</ul>
</main>
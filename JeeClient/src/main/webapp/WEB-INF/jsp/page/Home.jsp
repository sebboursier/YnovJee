<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<c:forEach items="${client.comptes}" var="compte">
			<li class="collection-item">${compte.libelle}</li>
    	</c:forEach>
	</ul>
</main>
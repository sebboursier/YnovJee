<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li class="collection-item row">
				<span class="col s3">
					${compte.libelle}
				</span>
				<span class="col s3">
					${compte.id}
				</span>
				<span class="col s3">
					${compte.amount} €
				</span>
				<span class="col s3 center-align">
					<a href="transactions?id=${compte.id}" class="waves-effect waves-light btn">
						Détails
					</a>
				</span>
			</li>
    	</c:forEach>
	</ul>
</main>
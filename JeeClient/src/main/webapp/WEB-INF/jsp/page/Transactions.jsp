<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="container">
	<section class="card-panel">
		<div class="row">
			<article class="col s6 center-align">
				Détails du compte "${compte.libelle}"
			</article>
			<article class="col s6 center-align">
				<label>
					Identifiant
				</label>
				<span>
					${compte.id}
				</span>
			</article>
		</div>
	</section>
	<ul class="collection with-header">
		<li class="collection-header"><h4>Transactions</h4></li>
		<c:forEach items="${compte.transactions}" var="transaction">
			<li class="collection-item row">
				<span class="col s4">
					${transaction.libelle}
				</span>
				<span class="col s4">
					${transaction.date}
				</span>
				<span class="col s4">
					${transaction.montant} €
				</span>
			</li>
    	</c:forEach>
	</ul>
</main>
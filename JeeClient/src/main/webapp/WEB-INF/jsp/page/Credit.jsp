<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="container">
	<c:if test="${response && error == null}">
		<section class="row">
        	<article class="card-panel white-text light-green">
        		Crédit effectué
        	</article>
		</section>
    </c:if>
    <c:if test="${error != null}">
		<section class="row">
        	<article class="card-panel white-text red">
        		${error}
        	</article>
		</section>
    </c:if>
	<section class="row">
		<form class="card" method="post" action="credit">
			<article class="card-content">
				<span class="card-title">
					Effectuer un nouveau crédit
				</span>
		        <div class="row">
		        	<label>Compte à créditer</label>
					<select class="browser-default" name="compte" required>
						<option value="" disabled selected>Veuillez sélectionner un compte</option>
						<c:forEach items="${comptes}" var="compte">
						 	<option value="${compte.id}">${compte.libelle}</option>
						</c:forEach>
					</select>
		        </div>
				<div class="input-field">
					<i class="material-icons prefix">euro_symbol</i>
		          <input name="montant" id="montant" type="number" step="0.01" class="validate" required>
		          <label for="montant">Montant</label>
		        </div>
		        <div class="input-field">
					<i class="material-icons prefix">tag</i>
		          <input name="libelle" id="libelle" type="text" class="validate" required>
		          <label for="libelle">Libelle</label>
		        </div>
			</article>
			<article class="card-action center-align">
				<button type="submit" class="waves-effect waves-light btn">
					Valider le crédit
				</button>
			</article>
		</form>
	</section>
</main>
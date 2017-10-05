<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banket - Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/Header.jsp" />
	<main class="container">
		<div class="row">
			<div class="col s12 m6 offset-m3">
				<form class="card">
					<div class="card-content">
						<span class="card-title"> Connectez-vous </span>
						<div class="input-field">
							<i class="material-icons prefix">account_circle</i> <input
								id="email" type="email" class="validate" required>
							<label for="email" class="active"> Identifiant </label>
						</div>
						<div class="input-field">
							<i class="material-icons prefix">lock</i>
							<input id="password" type="password" class="validate"
								required> <label for="password" class="active">
								Mot de passe </label>
						</div>
					</div>
					<div class="card-action center-align">
						<button type="submit" class="waves-effect waves-light btn">Connexion</button>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>
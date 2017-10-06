<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banket - ${page}</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- <link href="/assets/css/main.css"
	rel="stylesheet"> -->
</head>
<style>
	<jsp:include page="../../assets/css/main.css"/>
</style>
<body>
	<jsp:include page="Header.jsp" flush="true" />
	<jsp:include page="../page/${page}.jsp" flush="true" />
	<jsp:include page="Footer.jsp" flush="true" />
</body>
</html>
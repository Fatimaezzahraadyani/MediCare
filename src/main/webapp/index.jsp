
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% 
	if(session.getAttribute("name") == null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil MediCare</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center vh-100 bg-light">

    <div class="container text-center">
        <h1 class="mb-4">Bienvenue sur notre plateforme médocale</h1>
        <p class="lead">Veuillez vous connecter ou créer un compte pour accéder à nos services.</p>

        <div class="mt-4">
            <a href="login.jsp" class="btn btn-success btn-lg m-2">Se connecter</a>
            <a href="register.jsp" class="btn btn-primary btn-lg m-2">Créer un compte</a>
        </div>
    </div>

   
</body>
</html>

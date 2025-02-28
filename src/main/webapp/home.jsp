<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%
    // Vérification si le patient est connecté
    String patientName = (String) session.getAttribute("username");
    if (patientName == null) {
        response.sendRedirect("login.jsp"); // Redirige vers la connexion si non connecté
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil Patient</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">Espace Patient</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" href="Logout">Déconnexion</a>
                </li>
               
            </ul>
        </div>
    </div>
</nav>

<!-- Contenu principal -->
<div class="container mt-4">
    <h2 class="text-center">Bienvenue, <%= patientName %> !</h2>

    <div class="card mt-4">
        <div class="card-header bg-primary text-white">
            Mes Rendez-vous
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Heure</th>
                        <th>Médecin</th>
                        <th>Spécialité</th>
                        <th>Statut</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>12/03/2025</td>
                        <td>10:30</td>
                        <td>Dr. Dupont</td>
                        <td>Cardiologie</td>
                        <td><span class="badge bg-success">Confirmé</span></td>
                    </tr>
                    <tr>
                        <td>15/03/2025</td>
                        <td>14:00</td>
                        <td>Dr. Martin</td>
                        <td>Dermatologie</td>
                        <td><span class="badge bg-warning">En attente</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

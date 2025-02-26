<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center vh-100 bg-light">

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-lg">
                    <div class="card-body">
                        <h2 class="text-center mb-4">Créer un compte</h2>

                        <form action="Register" method="post">
                            <div class="mb-3">
                                <label for="nom" class="form-label">User Name</label>
                                <input type="text" class="form-control" id="nom" name="nom" required>
                            </div>

                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>

                            <div class="mb-3">
                                <label for="password" class="form-label">Mot de passe</label>
                                <input type="password" class="form-control" id="password" name="password" required minlength="8">
                            </div>

                            <div class="mb-3">
                                <label for="telephone" class="form-label">Numéro de téléphone</label>
                                <input type="text" class="form-control" id="telephone" name="telephone">
                            </div>

                            <div class="mb-3">
                                <label for="role" class="form-label">Je suis :</label>
                                <select class="form-select" id="role" name="role" required onchange="toggleSpecialisation()">
                                    <option value="patient">Patient</option>
                                    <option value="medecin">Médecin</option>
                                </select>
                            </div>

                            <div class="mb-3" id="specialisationDiv" style="display: none;">
                                <label for="specialisation" class="form-label">Spécialisation</label>
                                <input type="text" class="form-control" id="specialisation" name="specialisation">
                            </div>

                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">S'inscrire</button>
                            </div>
                        </form>

                        <p class="text-center mt-3">
                            Vous avez déjà un compte ? <a href="login.jsp">Connectez-vous ici</a>.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function toggleSpecialisation() {
            let role = document.getElementById("role").value;
            let specialisationDiv = document.getElementById("specialisationDiv");
            if (role === "medecin") {
                specialisationDiv.style.display = "block";
            } else {
                specialisationDiv.style.display = "none";
            }
        }
    </script>

</body>
</html>

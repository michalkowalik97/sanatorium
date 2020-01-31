<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Sanatorium - Panel</title>

    <%-- <link rel="stylesheet" href="w3.css">
 --%><%--
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>--%>

    <link rel="stylesheet" href="/main.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/975f2122b4.js"<%-- crossorigin="anonymous"--%>></script>

</head>
<body>
<nav class=" navbar-dark bg-dark pt-2 pb-2 navbar navbar-expand-lg">
    <div class="col-md-1 text-light "><a href="/" class="h3 text-white">Sanatorium</a></div>
    <div class="col-10"></div>

    <div class="dropdown float-right">
        <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown">
            ${sessionScope.user}
        </button>
        <div class="dropdown-menu">
            <%--<a class="dropdown-item" href="#">Link 1</a>
            <a class="dropdown-item" href="#">Link 2</a>--%>
            <a class="dropdown-item" href="/user/configuration/${sessionScope.user}">Ustawienia konta</a>
            <a class="dropdown-item" href="/logout">Wyloguj</a>
        </div>
    </div>

</nav>

<div class="container">
    <div class="row p-3">
        <div class="col text-success">
            <h1>
                ${message}
            </h1>

        </div>
    </div>


    <div class="row p-1 align-items-center">
        <div class="col-md-6">
            <div class="card border-info">
                <div class="card-header bg-transparent border-info h3">
                    <i class="fas fa-biohazard"></i> Zarządzaj pacjentami
                </div>
                <div class="card-body">
                    <a href="/showPatients" class="btn btn-info">Wyświetl wszystkich</a>
                    <a href="/addPatient" class="btn btn-info">Dodaj</a>
                    <a href="/deletePatient" class="btn btn-info">Usuń</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card border-info">
                <div class="card-header bg-transparent border-info h3">
                    <i class="fas fa-user-md"></i> Zarządzaj lekarzami
                </div>
                <div class="card-body">
                    <a href="/addDoctor" class="btn btn-info">Dodaj</a>
                    <a href="/deleteDoctor" class="btn btn-info">Usuń</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row p-1 align-items-center">
        <div class="col-md-6">
            <div class="card border-info">
                <div class="card-header bg-transparent border-info h3">
                    <i class="fas fa-hotel"></i> Zarządzaj pokojami
                </div>
                <div class="card-body">

                    <a href="/addRoom" class="btn btn-info">Dodaj</a>
                    <a href="/deleteRoom" class="btn btn-info">Usuń</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card border-info">
                <div class="card-header bg-transparent border-info h3">
                    <i class="fas fa-briefcase-medical"></i> Zarządzaj wizytami
                </div>
                <div class="card-body">
                    <a href="/addAppointment" class="btn btn-info">Dodaj</a>
                    <a href="/deleteAppointment" class="btn btn-info">Usuń</a>
                </div>
            </div>
        </div>
    </div>


</div>
</body>
</html>
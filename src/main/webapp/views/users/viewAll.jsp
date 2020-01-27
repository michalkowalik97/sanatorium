<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Sanatorium - form template</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/975f2122b4.js"<%-- crossorigin="anonymous"--%>></script>
    <style>

    </style>
</head>
<body>
<nav class=" navbar-dark bg-dark pt-2 pb-2 navbar navbar-expand-lg ">
    <div class="col-md-1 text-light "><a href="/" class="h3 text-white">Sanatorium</a></div>
    <div class="col-10"></div>

    <div class="dropdown float-right">
        <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown">
            ${sessionScope.user}
        </button>
        <div class="dropdown-menu">
            <%--<a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>--%>
            <a class="dropdown-item" href="/logout">Wyloguj</a>
        </div>
    </div>

</nav>



<div class="container border border-info pt-3 mt-5 table-responsive">


    <div class="row ">
        <div class="col text-danger align-content-center text-center h3" role="alert">
            ${error}
        </div>

    </div>
    <div class="row p-3">
        <div class="col text-info">
            <h2>
                ${message}
            </h2>

        </div>
    </div>

    <div class="p-3 ">
        <span class="h2">Użytkownicy</span>

        <a href="/addUser" class="btn-info btn float-right"> + Dodaj użytkownika</a>
    </div>

            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Login</th>
                    <th>Rola</th>
                    <th>Akcje</th>
                </tr>
                </thead>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.surname}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.permission.getName()}"/></td>
                        <td>
                            <a href="/editUser/<c:out value="${user.id}"/>" class="btn btn-info"> <i class="fa fa-wrench" aria-hidden="true"></i></a>
                            <a href="/deleteUser/<c:out value="${user.id}"/>" class="btn btn-danger"> <i class="fa fa-trash" aria-hidden="true"></i></a>

                        </td>
                    </tr>
                </c:forEach>
            </table>


</div>
</body>
</html>
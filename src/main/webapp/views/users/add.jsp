<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Sanatorium - nowy użytkownik</title>

    <link rel="stylesheet" href="main.css">

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

<div class="container border border-info pt-3 mt-5">


    <div class="row p-1 align-items-center">
        <div class="col-md-4   align-items-center ">

            <form action="/saveUser" method="post">

                <div class="form-group">
                    <label> Login
                    </label>
                    <input type="text" name="login" class="form-control">
                </div>

                <div class="form-group">
                    <label> Imię
                    </label>
                    <input type="text" name="name" class="form-control">
                </div>

                <div class="form-group">
                    <label> Nazwisko
                    </label>
                    <input type="text" name="surname" class="form-control">
                </div>


                <div class="form-group">
                    <label> Rola
                    </label>
                    <select name="role" class="form-control">
                        <c:forEach items="${permissions}" var="permission">
                            <option value="<c:out value="${permission.id}"/>">
                                <c:out value="${permission.name}"/>
                            </option>

                        </c:forEach>
                    </select>
                </div>


                <div class="form-group ">
                    <input type="Submit" value="Zapisz" class="btn btn-success">
                    <input type="reset" value="Resetuj" class="btn btn-light">
                    <a href="#" class="btn btn-light"> Powrót</a>
                </div>
            </form>
        </div>

    </div>

</div>
</body>
</html>
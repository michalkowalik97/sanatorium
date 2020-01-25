<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>

    <%-- <link rel="stylesheet" href="w3.css">
 --%><%--
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
   /*     div{
            border: 1px black solid;
        }*/
    </style>
</head>
<body>
<div class="">
    <div class="row bg-dark">
        <div class="col-md-1 text-light"><h3>sanatorium</h3></div>
        <div class="col-10"></div>
        <div class="col-1  float-right"><a href="/logout" class="text-md-right text-info">Wyloguj</a></div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col alert-success">
                <h1>zalogowano  ${sessionScope.user} </h1>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="col-2">
                <ul>
                    <li>Pacjenci</li>
                    <li>Wizyty</li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div class="col-10" ></div>

        </div>

    </div>



</body>
</html>
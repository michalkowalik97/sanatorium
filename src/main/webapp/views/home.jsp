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

    <div class="row bg-dark pt-2 pb-2">
        <div class="col-md-1 text-light "><h3>Sanatorium</h3></div>
        <div class="col-10"></div>
        <div class="col-1 h4 float-right"><a href="/logout" class="text-md-right text-info">Wyloguj</a></div>
    </div>
    <div class="container">
    <div class="container">
        <div class="row">
            <div class="col text-success">
                <h1>${message}</h1>
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
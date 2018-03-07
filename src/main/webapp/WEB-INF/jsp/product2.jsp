<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- test test -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Лучшие гвозди Украины</title>
    <meta charset="utf-8">
    <link rel="icon" href="/resources/img/nail.png">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default rounded borders and increase the bottom margin */
        .navbar {
            margin-bottom: 50px;
            border-radius: 0;
        }

        /* Remove the jumbotron's default bottom margin */
        .jumbotron {
            margin-bottom: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }
    </style>
</head>
<body>

<div class="jumbotron">
    <div class="container text-center">
        <h1>Лучшие гвозди</h1>
        <p>Острые, Круглые, Железные</p>
    </div>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Логотип</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Главная</a></li>

                <li><a role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">Контакт</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">

                    <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">

                        <li><a href="#">Добро пожаловать ${pageContext.request.userPrincipal.name} |</a></li>

                        <li> <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                            <a onclick="document.forms['logoutForm'].submit()">Выход</a></li>
                    </c:when>
                    <c:otherwise>

                    <!-- test test -->
                        <li><a href="/login"><span class="glyphicon glyphicon-user"></span>Вход</a></li>
                </c:otherwise>
                </c:choose>
                <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Корзина</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="collapse" id="collapseExample">
    <div class="well">
        Тел 38 (067) 123 98 54
    </div>
</div>

<!-- выводим список товаров -->
<div class="container">
    <c:if test="${!empty productList}">

        <div class="row">
            <c:forEach items="${productList}" var="product">
        <div class="col-sm-4">

            <div class="panel panel-primary">
                <div class="panel-heading">${product.name}</div>
                <div class="panel-body"><img src="${product.img}" class="img-responsive" style="width:100%" alt="Image"></div>
                <div class="panel-footer">${product.price}</div>
            </div>

        </div>
            </c:forEach>
    </div>
    </c:if>
</div><br>


<footer class="container-fluid text-center">

    <form class="form-inline">Самая честная рассылка:
        <input type="email" class="form-control" size="50" placeholder="Email Address">
        <button type="button" class="btn btn-danger">Подпишись</button>
    </form>
</footer>

</body>
</html>
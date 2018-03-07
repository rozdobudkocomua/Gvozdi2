<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title></title>
</head>
<body>


<c:if test="${!empty productList}">
    <table class="data">

        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.id}... ${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
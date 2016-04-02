<%-- 
    Document   : products
    Created on : Jan 22, 2016, 1:00:02 AM
    Author     : Volli
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Produkty</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                 
                <a href="<c:url value="/logout.htm"/>"class="btn  btn-danger btn-mini pull-right" style="margin-left: 5px"> Wyloguj się</a> 
   
                <a href="<c:url value="/order/basket.htm"/>" class="btn btn-warning btn-mini pull-right" style="margin-left: 5px">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    Koszyk</a>
                    <br>
                <c:if test="${currentUser.login == 'admin'}">
                <a href="<c:url value="/products/add.htm"/>"class="btn btn-success btn-mini pull-right" style="margin-left: 5px"> Dodaj Produkt</a> 
                <a href="<c:url value="/customers.htm"/>"class="btn btn-success btn-mini pull-right" style="margin-left: 5px"> Klienci</a> 
                <a href="<c:url value="/order/confirmedOrders.htm"/>"class="btn btn-success btn-mini pull-right" style="margin-left: 5px"> Zamowienia</a> 
                </c:if>
                
                <div class="container">
                    <hl>Produkty</hl>
                    <p>Wszystkie produkty dostępne w naszym sklepie</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${product.name}</h3>
                                <p>${product.description}</p>
                                <p>${product.unitPrice}PLN</p>
                                <p>Liczba sztuk w magazynie: ${ product.unitsInStock} </p>
                                <p>
                                <a href="<spring:url value="/products/product.htm?id=${product.productID}"/> "class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Szczegóły
                                </a>
                                </p> 

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>     
    </body>
</html>

<%-- 
    Document   : products
    Created on : Jan 22, 2016, 1:00:02 AM
    Author     : Volli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Klienci</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <a href="<c:url value="/logout.htm"/>"class="btn  btn-danger btn-mini pull-right" style="margin-left: 5px"> Wyloguj się</a> 
                <a href="<c:url value="/products/all.htm" />" class="btn btndefault btn-mini pull-right" style="margin-left: 5px">
                <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a> 
                
     
                <div class="container">
 
                    <hl>Klienci</hl>
                    <p>Wszyscy klienci naszego sklepu</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <c:forEach items="${customers}" var="customer">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${customer.name}</h3>
                                <p>Adres: ${customer.address}</p>
                                <p>Ilosc zlozonych zamowien: ${customer.noOfOrdersMade}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>     
    </body>
</html>

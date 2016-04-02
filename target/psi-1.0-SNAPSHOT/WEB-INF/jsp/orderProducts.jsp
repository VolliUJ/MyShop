
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Lista Produktow</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                 
                <a href="<c:url value="/logout.htm"/>"class="btn  btn-danger btn-mini pull-right" style="margin-left: 5px"> Wyloguj się</a> 
                <a href="<spring:url value="/order/confirmedOrders.htm" />" class="btn btndefault btn-mini pull-right" style="margin-left: 5px">
                <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a> 
                <div class="container">
                    <hl>Lista Produktow</hl>
                    <p>Informacje o zamowieniu</p>
                </div>
            </div>
        </section>
    
        <section class="container">
            <div class="row">
                <h2 class="sub-header">Lista produktow</h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>#</th>
                            <th>Nazwa</th>
                            <th>Kategoria</th>
                            <th>Marka</th>
                            <th>Ilosc</th>
                            <th>Opis</th>
                          </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${itemList}" var="product">
                            <tr>
                                <td>${product.productID}</td>
                                <td>${product.name}</td>
                                <td>${product.category}</td>
                                <td>${product.manufacturer}</td>
                                <td>${product.unitsInOrder}</td>
                                <td>${product.description}</td>
                            </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
                            
            
            </div>
        </section>     
    </body>
</html>

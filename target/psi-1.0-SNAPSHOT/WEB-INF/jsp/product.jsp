<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Produkt</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                   <a href="<c:url value="/logout.htm"/>"class="btn  btn-danger btn-mini pull-right" style="margin-left: 5px"> Wyloguj się</a> 
                <a href="<c:url value="/products/all.htm" />" class="btn btndefault btn-mini pull-right" style="margin-left: 5px">
                <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a> 
                
     
                <div class="container">
                    <hl>Produkt</hl>
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
            <div class="col-md-5">
                <h3>${product.name} </h3>
                <p>${product.description}</p>
                <p>
                <strong>Kod produktu: </strong><span class="label label-warning">${product.productID}</span>
                </p>
                <p>
                <strong>Producent</strong>: ${product.manufacturer}
                </p>
                <p>
                <strong>Kategoria</strong>: ${product.category}
                </p>
                <p>
                <strong>Dostępna liczba sztuk</strong>: ${product.unitsInStock}
                </p>
                <h4>${product.unitPrice}PLN</h4>
                <p>
                <a href="<spring:url value="/products/all.htm" />" class="btn btndefault">
                <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a> 
                    
                <a href="<spring:url value="/order/${product.productID}/1.htm"/>" class="btn btn-warning btn-large">
                <span class="glyphicon-shopping-cart glyphicon"></span>
                    Zamow teraz
                </a>
                </p>
            </div>
        </div>
    </section>
    </body>
</html > 
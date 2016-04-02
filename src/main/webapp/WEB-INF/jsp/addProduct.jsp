<%-- 
    Document   : addProduct
    Created on : Jan 25, 2016, 2:22:13 AM
    Author     : Volli
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                
                <a href="<c:url value="/logout.htm"/>"class="btn  btn-danger btn-mini pull-right" style="margin-left: 5px"> Wyloguj się</a> 
                <a href="<c:url value="/products/all.htm" />" class="btn btndefault btn-mini pull-right" style="margin-left: 5px">
                <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a> 
                
                
                <div class="container">
                    <hl>Produkty</hl>
                    <p>Dodaj produkty</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal">
            <fieldset>
                <legend>Dodaj nowy produkt</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productID">Id produktu</label>
                    <div class="col-lg-lO">
                        <form:input id="productID" path="productID" type="text" class="form:input-large"/>
                    </div>
                </div>
        
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Nazwa</label>
                    <div class="col-lg-lO">
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="category">Kategoria</label>
                    <div class="col-lg-lO">
                        <form:input id="category" path="category" type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Marka</label>
                    <div class="col-lg-lO">
                        <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Cena</label>
                    <div class="col-lg-lO">
                        <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Ilosc</label>
                    <div class="col-lg-lO">
                        <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                    </div>
                </div>         
                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">Opis</label>
                    <div class="col-lg-lO">
                        <form:textarea id="description" path="description" rows="2" />
                    </div>
                </div>
          
                <div class="form-group">
                    <label class="control-label col-lg-2"
                    for="condition">Stan</label>
                    <div class="col-lg-lO">
                        <form:radiobutton path="condition" value="New"/>Nowy
                        <form:radiobutton path="condition" value="Old" />Uzywany
                        <form:radiobutton path="condition" value="Refurbished"/>Odnowiony
                    </div>
                </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-lO">
                            <input type="submit" id="btnAdd" class="btnbtn-primary"
                            value="Dodaj"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html > 
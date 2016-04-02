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
    <title>Rejestracja</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">

                <div class="container">
                    <hl>Rejestracja</hl>
                    <p>Zarejestruj sie</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newCustomer" class="form-horizontal">
            <fieldset>
                <legend>Podaj swoje dane</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="Login">Login</label>
                    <div class="col-lg-lO">
                        <form:input id="login" path="login" type="text" class="form:input-large"/>
                    </div>
                </div>
        
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="password">Haslo</label>
                    <div class="col-lg-lO">
                        <form:input id="password" path="password" type="text" class="form:input-large"/>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Imie i Nazwisko</label>
                    <div class="col-lg-lO">
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="address">Adres</label>
                    <div class="col-lg-lO">
                        <form:input id="address" path="address" type="text" class="form:input-large"/>
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
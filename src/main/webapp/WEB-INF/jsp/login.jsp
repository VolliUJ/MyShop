<%-- 
    Document   : login
    Created on : Jan 25, 2016, 3:34:06 AM
    Author     : Volli
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Logowanie</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <hl>Logowanie</hl>
                    
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Zaloguj się</h3>
                        </div>
                        <div class="panel-body">
                            
                            <c:if test="${errorMessage != null}">
                                <div class="alert alert-danger">
                                    ${errorMessage}
                                </div>
                            </c:if>
                            <form:form modelAttribute="loginUser" class="form-signin">
                                
                                <fieldset>
                                    <div class="form-group">
                                        <form:input id="userId" path="login" type="text" class="form:input-large"/>
                                    </div>
                                    <div class="form-group">
                                        <form:input id="password" path="password" type="text" class="form:input-large"/>
                                    </div>
                                    <input type="submit" id="btnAdd" class="btn btn-primary btn-mini pull-left" value="Zaloguj"/>
                                    <a href="<c:url value="register.htm"/>"class="btn btn-primary btn-mini pull-left" style="margin-left: 5px"> Zarejestruj</a> 
                                </fieldset>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html >             
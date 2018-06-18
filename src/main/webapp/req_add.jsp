<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add request</title>
        <!-- Favicon -->
        <link rel="shortcut icon" href="../resources/images/favicon.ico">
        <link href="../resources/css/form.css" rel="stylesheet" type="text/css" />              
    </head>
    <body>                  
        <div id="main">               
            <div id="content"> 
                <div id="form_name"><h1>Add Request</h1></div>
                <c:if test="${not empty error}">
                    <h2 style="color: #000">${error}</h2>
                </c:if>
                <c:if test="${not empty msg}">
                    <h2 style="color: #000">${msg}</h2>
                </c:if>
                <form:form class="formBox" id="form-add" action="/request/add" method="post">
                    <fieldset>
                        <h2>Please, give us more info about a new request</h2>
                        <div class="form-col">
                            <label for="request" class="lab">Request</label>
                            <input type="text" required name="request" class="input" id="request" />
                        </div>
                        <div class="form-col form-col-right">
                            <label for="bid" class="lab">bid</label>
                            <input type="text" required name="bid" class="input" id="bid" />
                        </div>
                        <div class="form-col">
                            <label for="dueDate" class="lab">Date</label>
                            <input type="text" required name="dueDate" class="input" id="dueDate" />                 
                        </div>                       
                    </fieldset>                       
                        <input type="submit" name ="addReq" value="Add" class="submit"/>
                        <input type="submit" name ="cancel" value="Cancel" class="submit" onClick="history.go(-1);"/>                 
                </form:form>
            </div>
        </div><!-- /content -->
    </body>
</html>

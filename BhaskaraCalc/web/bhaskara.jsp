<%@page import="java.lang.NullPointerException"%>
<%@page import="br.uninove.bhaskara.Bhaskara"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String a, b, c;
    a = request.getParameter("valorA");
    b = request.getParameter("valorB");
    c = request.getParameter("valorC");
    Bhaskara bhaskara = new Bhaskara();
    try{
        double vA, vB, vC;
        vA = Double.parseDouble(a);
        vB = Double.parseDouble(b);
        vC = Double.parseDouble(c);
        
        bhaskara = new Bhaskara(vA, vB, vC);
        if(vA == 0) {
            throw new NullPointerException();
        }
        
        bhaskara.calculaDelta();
        
    } catch(Exception ex) {
        if(ex.getClass() == NullPointerException.class)
            out.print("A não podia zer zero!");
        else 
            out.print("Erro na conversão numérica");
        
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora de Bhaskara</title>
    </head>
    <body>
        <h1>Calculadora de Bháskara</h1>
        <hr>
        <strong>Dado:</strong>
        <p><%=a%>x² + <%=b%>x + <%=c%> = 0, temos:</p>
        <br>
        <p><strong>Delta: </strong><%= bhaskara.getDelta() %></p>
        <% if(bhaskara.getDelta() <= 0) { %>
            <p>Delta é menor ou igual a zero, portanto não há raízes reais para essa equação</p>
        <% } else { %>
            <p><strong>Raiz': </strong><%= bhaskara.getrP()%></p>
            <p><strong>Raiz'': </strong><%= bhaskara.getrN()%></p>
        <% } %>
    </body>
</html>

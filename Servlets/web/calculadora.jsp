<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h1>Super Calculadora</h1>
        <hr>
        <%
            String vA, vB;
            vA = request.getParameter("a") != null ? request.getParameter("a") : "";
            vB = request.getParameter("b") != null ? request.getParameter("b") : "";
        %>
        
        <form method="POST" action="CalcController">
            <div>
                <label>Valor A: </label>
                <input type="number" step="0.01" name="valorA" value="<%=vA%>">
            </div>
            <div style="margin: 20px 0 20px 0">
                <label>Valor B: </label>
                <input type="number" step="0.01" name="valorB" value="<%=vB%>">
            </div>
            <input type="submit" value="Somar" name="btCalcular">
            <input type="submit" value="Subtrair" name="btCalcular">
            <input type="submit" value="Multiplicar" name="btCalcular">
            <input type="submit" value="Dividir" name="btCalcular">
            <input type="submit" value="Potencia" name="btCalcular">
        </form>
        <% if(request.getParameter("result") != null) { %>
            <hr>
            <strong>Resultado: </strong><%= request.getParameter("result") %>
        <% } %>
    </body>
</html>

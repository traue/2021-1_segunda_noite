<%@page import="br.uninove.imc.Imc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora JSP</title>
    </head>
    <body>
        <h1>Calculadora IMC</h1>
        <hr>
        <%
           float altura, peso;
           altura = Float.parseFloat(request.getParameter("altura"));
           peso = Float.parseFloat(request.getParameter("peso"));
           
           Imc imc = new Imc();
           
           imc.setAltura(altura);
           imc.setPeso(peso);
        %>
        <p><strong>Altura: </strong> <%= altura %></p>
        <p><strong>Peso: </strong> <%= peso %></p>
        <p><strong>IMC: </strong> <%= String.format("%.2f", imc.calculaIMC()) %></p>
        <p><strong>Classificação: </strong> <%= imc.getClassificacao() %></p>
        
        <br><br>
        <a href="index.html">Calcular novamente</a>
    </body>
</html>

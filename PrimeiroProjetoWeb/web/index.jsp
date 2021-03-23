<%@page import="br.uninove.pojo.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primeiro JSP</title>
    </head>
    <body>
        <h1>Minha primeira página JSP! Uhu!</h1>
        <hr>
        
        <%
//            String nome = "Thiago G. Traue";
//            int idade = 33;
//            boolean fumante = false;
            Pessoa p = new Pessoa();
            p.setNome("Thiago G. Traue");
            p.setIdade(33);
            p.setFumante(false);
        %>
        
        <p><strong>Seus dados:</strong></p>
        <p><strong>Nome: </strong> <%= p.getNome() %></p>
        <p><strong>Idade: </strong> <%= p.getIdade() %></p>
        <p><strong>Fumante? </strong> <%= (p.isFumante() ? "Sim" : "Não") %></p>
        
    </body>
</html>

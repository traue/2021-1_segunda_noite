<%@page import="br.sisacademico.model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.sisacademico.dao.AlunoDAO"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   AlunoDAO aDAO = new AlunoDAO();
   ArrayList<Aluno> alunos;
   boolean mostraPainelFiltro = false;
   if(request.getParameter("idCurso") != null) {
       int idCurso =  Integer.parseInt(request.getParameter("idCurso"));
       alunos = aDAO.getAlunos(idCurso);
       mostraPainelFiltro = true;
   } else {
       alunos = aDAO.getAlunos();
   }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SisAcadêmico</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
        <% if(mostraPainelFiltro && alunos.size() > 0) { %> 
        <div class="container mt-4">
            <div class="card" style="width: 90%; margin: 0 auto !important;">
                <div class="card-header bg-dark">
                    <p class="text-white">Filtro aplicado</p>
                </div>
                <div class="card-body">
                    <h6 class="card-title">
                        Mostrando apenas alunos do curso:
                        <strong>
                            <%= alunos.get(0).getCurso().getNomeCurso() %>
                        </strong>
                    </h6>
                        <a href="aluno.jsp" class="btn btn-primary">Limpar filtro</a>
                </div>
            </div>
        </div>
        <% } %>
        <div class="container mt-4">
            <div class="table-responsive-md" style="width: 90%; margin: 0 auto !important;">
                <table class="table justify-content-center">
                    <thead class="thead-dark">
                        <th>RA</th>
                        <th>Nome</th>
                        <th>Curso</th>
                        <th>Tipo de Curso</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </thead>
                    <tbody>
                        <% for(Aluno a: alunos) { %>
                        <tr>
                            <td><%= a.getRa() %></td>
                            <td><%= a.getNome() %></td>
                            <td><%= a.getCurso().getNomeCurso() %></td>
                            <td><%= a.getCurso().getTipoCurso() %></td>
                            <td>Bt. Editar Aluno</td>
                            <td>Bt. Excluir Aluno</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
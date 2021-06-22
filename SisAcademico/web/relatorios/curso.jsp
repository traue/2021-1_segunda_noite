<%@page import="java.util.Map"%>
<%@page import="br.sisacademico.model.Curso"%>
<%@page import="br.sisacademico.dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CursoDAO cDAO = new CursoDAO();
    Map<Curso, Integer> cursos = cDAO.getTodosCursoCountAunos();
    int contador = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SisAcadêmico</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
            <script src="../js/modal_exclusao.js"></script>
            <script>
                $(function () {
                    $('[data-toggle="tooltip"]').tooltip()
                })
            </script>
            <div class="container mt-4">
                <div class="table-responsive-md" style="width: 90%; margin: 0 auto !important;">
                    <table class="table justify-content-center table-striped table-hover">
                        <thead class="thead-dark table-dark">
                        <th class="text-center">#</th>    
                        <th class="text-center">Curso</th>
                        <th>Tipo de Curso</th>
                        <th class="text-center">Qtd. Alunos</th>
                        <th class="text-center">Ver alunos</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Excluir</th>
                        </thead>
                        <tbody>
                        <% for (Map.Entry<Curso, Integer> c : cursos.entrySet()) {%>
                        <tr>
                            <td class="text-center"><%=contador++%></td>
                            <td><%=c.getKey().getNomeCurso()%></td>
                            <td><%=c.getKey().getTipoCurso()%></td>
                            <td class="text-center"><%= c.getValue()%></td>
                            <% if (c.getValue() == 0) { %>
                            <td class="text-center">
                                <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Sem alunos para exibir">
                                    <button class="btn btn-secondary" disabled style="pointer-events: none;" type="button">Alunos Matriculados</button>
                                </span>
                            </td>
                            <% } else {%>
                            <td class="text-center"><a href="./aluno.jsp?idCurso=<%=c.getKey().getIdCurso()%>" class="btn btn-success">Alunos Matriculados</a></td>
                            <% }%>
                            <td class="text-center"><a class="btn btn-info" href="../cadastros/curso.jsp?idCurso=<%=c.getKey().getIdCurso()%>">Editar</a></td>
                            <% if (c.getValue() != 0) { %>
                            <td class="text-center"> 
                                <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Você não pode excluir um curso com alunos">
                                    <button class="btn btn btn-secondary" disabled style="pointer-events: none;" type="button">Excluir</button>
                                </span>
                            </td>
                            <% } else {%>
                            <td class="text-center"><a id="deleteCurso" href="../CursoController?acao=delete&idCurso=<%=c.getKey().getIdCurso()%>" class="btn btn-danger">Excluir</a></td>
                            <% } %>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
                <a href="../cadastros/curso.jsp" class="btn btn-info">Novo Curso</a>
            </div>
        </div>
    </body>
</html>

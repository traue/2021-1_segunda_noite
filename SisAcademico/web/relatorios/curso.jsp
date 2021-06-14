<%@page import="java.util.Map"%>
<%@page import="br.sisacademico.model.Curso"%>
<%@page import="br.sisacademico.dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CursoDAO cDAO = new CursoDAO();
    Map<Curso, Integer> cursos = cDAO.getTodosCursoCountAunos();
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
                    <table class="table justify-content-center">
                        <thead class="thead-dark">
                        <th>Curso</th>
                        <th>Tipo de Curso</th>
                        <th>Qtd. Alunos</th>
                        <th>Ver alunos</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                        </thead>
                        <tbody>
                        <% for (Map.Entry<Curso, Integer> c : cursos.entrySet()) {%>
                        <tr>
                            <td><%=c.getKey().getNomeCurso()%></td>
                            <td><%=c.getKey().getTipoCurso()%></td>
                            <td><%= c.getValue()%></td>
                            <% if (c.getValue() == 0) { %>
                            <td>
                                <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Sem alunos para exibir">
                                    <button class="btn btn-secondary" disabled style="pointer-events: none;" type="button">Alunos Matriculados</button>
                                </span>
                            </td>
                            <% } else { %>
                                <td><a href="./aluno.jsp?idCurso=<%=c.getKey().getIdCurso()%>" class="btn btn-success">Alunos Matriculados</a></td>
                            <% } %>
                            <td>Bt. Editar Curso</td>
                            <% if (c.getValue() != 0) { %>
                            <td>
                                <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Você não pode excluir um curso com alunos">
                                    <button class="btn btn btn-secondary" disabled style="pointer-events: none;" type="button">Excluir</button>
                                </span>
                            </td>
                            <% } else { %>
                            <td><a id="deleteCurso" href="../CursoController?acao=delete&idCurso=<%=c.getKey().getIdCurso()%>" class="btn btn-danger">Excluir</a></td>
                            <% } %>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

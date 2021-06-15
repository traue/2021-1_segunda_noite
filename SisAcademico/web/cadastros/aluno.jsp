<%@page import="br.sisacademico.dao.CursoDAO"%>
<%@page import="br.sisacademico.model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CursoDAO cDAO = new CursoDAO();
    ArrayList<Curso> cursos = cDAO.getCurso();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SisAcadêmicop</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
            <div class="container mt-4">
                <div style="width: 40%; margin: 0 auto !important;">
                    <form action="../AlunoController" method="post">
                        <div class="form-group">
                            <label>RA</label>
                            <input type="number" name="raAluno" required class="form-control" placeholder="Informe o RA do aluno">
                        </div>
                        <div class="form-group mt-3">
                            <label>Nome do aluno</label>
                            <input type="text" name="nomeAluno" required class="form-control" placeholder="Informe o nome do aluno">
                        </div>
                        <div class="form-group mt-3">
                            <label>Selecione o Curso</label>
                            <select name="idCurso" class="form-control">
                            <% for (Curso c : cursos) {%>
                            <option value="<%=c.getIdCurso()%>"><%= c.getNomeCurso() + " (" + c.getTipoCurso() + ")"%></option>
                            <% }%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary w-100 mt-3" value="Cadastrar">
                    <input type="hidden" name="acao" value="cadastro">
                </form>
            </div>
        </div>
    </body>
</html>

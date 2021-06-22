<%@page import="br.sisacademico.dao.CursoDAO"%>
<%@page import="br.sisacademico.model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String acao = "cadastro";
    String textBt = "Cadastrar";
    Curso curso = new Curso();
    
    if(request.getParameter("idCurso") != null) {
        CursoDAO cDAO = new CursoDAO();
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        curso = cDAO.getCurso(idCurso).get(0);
        acao = "editar";
        textBt = "Salvar";
    } else {
        curso.setNomeCurso("");
        curso.setTipoCurso("");
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
        <div class="container mt-4">
            <div style="width: 30%; margin: 0 auto !important;">
                <form method="post" action="../CursoController">
                    <div class="form-group">
                        <label>Nome do curso</label>
                        <input type="text" required name="nomeCurso" value="<%=curso.getNomeCurso()%>" class="form-control" placeholder="Insira o nome do curso">
                    </div>
                    <div class="form-group mt-3">
                        <label>Tipo de curso</label>
                        <input type="text" required name="tipoCurso" value="<%=curso.getTipoCurso()%>" class="form-control" placeholder="Insira o tipo do curso">
                    </div>
                    <input type="submit" value="<%=textBt%>" class="btn btn-primary w-100 mt-3">
                    <input type="hidden" name="acao" value="<%=acao%>">
                    <input type="hidden" name="idCurso" value="<%=curso.getIdCurso()%>">
                </form>
            </div>
        </div>
    </body>
</html>

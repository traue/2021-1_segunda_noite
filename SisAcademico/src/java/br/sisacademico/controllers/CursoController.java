package br.sisacademico.controllers;

import br.sisacademico.dao.CursoDAO;
import br.sisacademico.model.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getParameter("acao");
            
            if(acao.equalsIgnoreCase("delete")) {
                CursoDAO cDAO = new CursoDAO();
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                if(cDAO.deleteCurso(idCurso))
                    response.sendRedirect("./relatorios/curso.jsp");
            } else if(acao.equalsIgnoreCase("cadastro")) {
                CursoDAO cDAO = new CursoDAO();
                Curso c = new Curso();
                c.setNomeCurso(request.getParameter("nomeCurso"));
                c.setTipoCurso(request.getParameter("tipoCurso"));
                if(cDAO.insereCurso(c)){
                    response.sendRedirect("./relatorios/curso.jsp");
                }
            } else if(acao.equalsIgnoreCase("editar")) {
                CursoDAO cDAO = new CursoDAO();
                if(cDAO.atualizaCurso(
                        Integer.parseInt(request.getParameter("idCurso")), 
                        request.getParameter("nomeCurso"), 
                        request.getParameter("tipoCurso"))) {
                    response.sendRedirect("./relatorios/curso.jsp");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

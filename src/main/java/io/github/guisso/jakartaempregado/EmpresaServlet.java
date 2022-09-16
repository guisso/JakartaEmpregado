/*
 * CC BY-NC-SA 4.0
 *
 * Copyright 2022 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;.
 *
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 * You are free to:
 *   Share - copy and redistribute the material in any medium or format
 *   Adapt - remix, transform, and build upon the material
 *
 * Under the following terms:
 *   Attribution - You must give appropriate credit, provide 
 *   a link to the license, and indicate if changes were made.
 *   You may do so in any reasonable manner, but not in any 
 *   way that suggests the licensor endorses you or your use.
 *   NonCommercial - You may not use the material for commercial purposes.
 *   ShareAlike - If you remix, transform, or build upon the 
 *   material, you must distribute your contributions under 
 *   the same license as the original.
 *   No additional restrictions - You may not apply legal 
 *   terms or technological measures that legally restrict 
 *   others from doing anything the license permits.
 *
 * Notices:
 *   You do not have to comply with the license for elements 
 *   of the material in the public domain or where your use 
 *   is permitted by an applicable exception or limitation.
 *   No warranties are given. The license may not give you 
 *   all of the permissions necessary for your intended use. 
 *   For example, other rights such as publicity, privacy, 
 *   or moral rights may limit how you use the material.
 */
package io.github.guisso.jakartaempregado;

import io.github.guisso.jakartaempregado.util.TipoSanguineo;
import io.github.guisso.jakartaempregado.empregado.Empregado;
import io.github.guisso.jakartaempregado.empregado.EmpregadoBeanLocal;
import io.github.guisso.jakartaempregado.log.Log;
import io.github.guisso.jakartaempregado.log.LogBeanLocal;
import io.github.guisso.jakartaempregado.util.OperacoesBancoDados;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
@WebServlet(
        name = "EmpresaServlet",
        urlPatterns = {"/EmpresaServlet"})
public class EmpresaServlet extends HttpServlet {

    @Inject
    EmpregadoBeanLocal empregadoBean;

    @Inject
    LogBeanLocal logBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            // Objeto a ser persistido
            Empregado e = new Empregado();
            e.setNome("Luis");
            e.setEmail("luis@mail.com");
            e.setNascimento(LocalDate.of(1975, 3, 2));
            e.setSalario(new BigDecimal("99999.99"));
            e.setTipoSanguineo(TipoSanguineo.OPositivo);
            e.setAtivo(true);

            try {
                // Persistência
                empregadoBean.salvar(e);
            } catch (Exception ex) {
                Logger.getLogger(EmpresaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Registro da operação
            Log l = new Log(OperacoesBancoDados.INSERCAO.toString(),
                    this.getClass().getName() + "> " + e);
            try {
                logBean.registrar(l);
            } catch (Exception ex) {
                Logger.getLogger(EmpresaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Verificação da persistência
            Empregado eAux = empregadoBean.localizarPorId(1L);
            Log lAux = logBean.localizarPorId(1L);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpresaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpresaServlet</h1>");
            out.println("<h2>Empregado em BD: " + eAux + "</h2>");
            out.println("<h3>Log em BD: " + lAux + "</h3>");

            out.println("</body>");
            out.println("</html>");
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

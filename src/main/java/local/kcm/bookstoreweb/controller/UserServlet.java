package local.kcm.bookstoreweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import local.kcm.bookstoreweb.model.bean.User;
import local.kcm.bookstoreweb.model.dao.BookDAO;
import local.kcm.bookstoreweb.model.dao.UserDAO;

/**
 *
 * @author Kaylane
 */

public class UserServlet extends HttpServlet{
    
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

        String action = request.getPathInfo();
        Logger.getLogger(BookServlet.class.getName()).log(Level.INFO, "Path solicitado: {0}", action);

        if (action == null) {
            action = "/list";
        }
        
        try {
            switch (action) {
                case "/new":
                    showNewUserForm(request, response);
                    break;
                case "/insert":
                    insertUserAction(request, response);
                    break;
                case "/list":
                    listUsers(request, response);
                    break;
                case "/edit":
                    showEditUserForm(request, response);
                    break;
                case "/update":
                    updateUserAction(request, response);
                    break;
                case "/delete":
                    deleteUserAction(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Metodos da Kaylane. Click on the + sign on the left to edit the code.">
    
    /**
     * Exibe a lista completa de usuarios
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     */
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        List<User> listaUsers = userDAO.getResults();

        Logger.getLogger(BookDAO.class.getName()).log(Level.INFO,
                "Total de registros: {0}", listaUsers.size());

        request.setAttribute("listaUsers", listaUsers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertUserAction(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        UserDAO userDAO = new UserDAO();
        User novoUser = new User();
        novoUser.setEmail(request.getParameter("formEmail"));
        novoUser.setPassword(request.getParameter("formPassword"));
        novoUser.setFullname(request.getParameter("formFullname"));

        userDAO.create(novoUser);
        response.sendRedirect("list");
    }
    
    private void showEditUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        User atualizaUser = userDAO.getResultById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
        request.setAttribute("user", atualizaUser);
        dispatcher.forward(request, response);
    }
    
    private void updateUserAction(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        UserDAO userDAO = new UserDAO();
        User Useratualizado = new User();
        Useratualizado.setId(Integer.parseInt(request.getParameter("formId")));
        Useratualizado.setEmail(request.getParameter("formEmail"));
        Useratualizado.setPassword(request.getParameter("formPassword"));
        Useratualizado.setFullname(request.getParameter("formFullname"));

        userDAO.update(Useratualizado);
        response.sendRedirect("list");
    }
    
    private void deleteUserAction(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserDAO userDAO = new UserDAO();
        userDAO.delete(id);
        response.sendRedirect("list");
    }
    
    // </editor-fold>
    
    
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

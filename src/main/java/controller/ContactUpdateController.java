package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.repository.ContactRepository;

/**
 * Servlet implementation class DeleteContactController
 */
public class ContactUpdateController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO
        String id = request.getParameter("id");
        ContactRepository bd = ContactRepository.getInstance();
        Contact c = bd.getContact(id);
        bd.updateContact(c);
        request.setAttribute("contact", c);
        request.getRequestDispatcher("/contactEditView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        ContactRepository bd = ContactRepository.getInstance();
        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String phone = request.getParameter("phone");
        Contact c = bd.getContact(id);
        c.setName(nombre);
        c.setTelephone(phone);
        bd.updateContact(c);
        request.setAttribute("message", "Contacto actualizado!");
        request.getRequestDispatcher("/contactEditView.jsp").forward(request, response);
    }

}

package com.neu.spring.mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.spring.ejb.MailSenderBean;

/**
 * Servlet implementation class Mail
 */
public class Mail extends HttpServlet {

	
    @EJB
    private MailSenderBean mail;
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		 response.setContentType("text/html;charset=UTF-8");
		 System.out.println("2");
		String toEmail = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		String fromEmail="bank.bostonhr@yahoo.com";
		String username ="bank.bostonhr@yahoo.com";
		String password="santoshwale";
		
		 System.out.println("3");
	    PrintWriter out = response.getWriter();
	    System.out.println("4");
	        mail.sendEmail(fromEmail, username, password, toEmail, subject, message);
	        System.out.println("5");
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Mail Status</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Mail Status!!</h1>");
	            out.println("<b>Mail Sent Successfully!!</b><br>");
	            out.println("Click <a href='emailClient.jsp'>here</a>to go back");
	            out.println("</body>");
	            out.println("</html>");
	        
	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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

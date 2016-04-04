package ru.adduxa.inetApps.Lab7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ControllerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/AreaCheckServlet").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WebFormServlet").forward(request, response);
	}
}

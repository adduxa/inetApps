package ru.adduxa.inetApps.Lab7;

import java.io.IOException;

public class WebFormServlet extends javax.servlet.http.HttpServlet {
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		
	}
	
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		getServletContext().getRequestDispatcher("/form.html").forward(request, response);
	}
}
